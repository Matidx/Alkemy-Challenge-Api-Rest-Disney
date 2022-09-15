package com.api.rest.disney.controller;

import com.api.rest.disney.models.Character;
import com.api.rest.disney.models.Movie;
import com.api.rest.disney.service.implement.CharacterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterServiceImpl characterServiceImpl;

    @GetMapping("/all")
    public ResponseEntity<List<Character>> findAllCharacters (){
        return new ResponseEntity<>(characterServiceImpl.findAllCharacters(), HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Character> findCharacterById (@PathVariable Long id){
            return new ResponseEntity<>(characterServiceImpl.findCharacterById(id),HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<?> findByWeightOrNameOrAgeCharacter(@RequestParam(value = "weight", required = false) Double weight,
                                                              @RequestParam(value = "name", required = false) String name,
                                                              @RequestParam(value = "age", required = false) Integer age) {
        if (weight != null) {
            return ResponseEntity.status(HttpStatus.OK).body(characterServiceImpl.findByWeightOrderByNameAsc(weight));
        }
        if (name != null) {
            return ResponseEntity.status(HttpStatus.OK).body(characterServiceImpl.findByName(name));
        }
        if (age != null) {
            return ResponseEntity.status(HttpStatus.OK).body(characterServiceImpl.findByAgeOrderByNameAsc(age));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't find correct param");
    }

    @GetMapping("/{id}/movies")
    public ResponseEntity<Collection<Movie>> movieByCharacter (@PathVariable Long id) {
        Character character = characterServiceImpl.findCharacterById(id);
        if (character != null) {
            return new ResponseEntity<>(character.getMovies(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/save")
    public ResponseEntity<Character> saveCharacter (@Valid @RequestBody Character character) {
        return new ResponseEntity<>(characterServiceImpl.saveCharacter(character), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Character> updateCharacter (@PathVariable Long id,@Valid @RequestBody Character character) {
        Optional<Character> optionalCharacter = Optional.ofNullable(this.characterServiceImpl.findCharacterById(id));
        Character characterGet = optionalCharacter.get();
        character.setIdCharacter(characterGet.getIdCharacter());
        character.setMovies(characterGet.getMovies());
        return new ResponseEntity<>(characterServiceImpl.saveCharacter(character), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCharacter (@PathVariable(name = "id") Long id) {
        characterServiceImpl.deleteCharacterById(id);
        return new ResponseEntity<>("Character removed successfully. Id= " + id, HttpStatus.OK );
    }
}
