package com.api.rest.disney.controller;

import com.api.rest.disney.models.Character;
import com.api.rest.disney.models.Movie;
import com.api.rest.disney.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("/all")
    public ResponseEntity<Collection<Character>> findAll (){
        return new ResponseEntity<>(characterService.findAll(), HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Character> findCharacterById (@PathVariable Long id){

        Character character =characterService.findCharacterById(id);
        if (character != null) {
            return new ResponseEntity<>(characterService.findCharacterById(id),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping()
    public Optional<List<Character>> getByWeightOrNameOrAgeCharacter(@RequestParam(value = "weight", required = false) Double weight,
                                                                @RequestParam(value = "name", required = false) String name,
                                                                @RequestParam(value = "age", required = false) Integer age) {
        if (weight != null) {
            return characterService.findByWeightOrderByNameAsc(weight);
        } if (name != null) {
            return characterService.findByName(name);
        } else {
            return characterService.findByAgeOrderByNameAsc(age);
        }
    }

    @GetMapping("/{id}/movies")
    public ResponseEntity<Collection<Movie>> movieByCharacter (@PathVariable Long id) {
        Character character = characterService.findCharacterById(id);
        if (character != null) {
            return new ResponseEntity<>(character.getMovies(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Character> saveCharacter (@RequestBody Character character) {
        return new ResponseEntity<>(characterService.saveCharacter(character), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Character> updateCharacter (@PathVariable Long id, @RequestBody Character character) {
        Optional<Character> optionalCharacter = Optional.ofNullable(this.characterService.findCharacterById(id));
        Character characterGet = optionalCharacter.get();
        character.setIdCharacter(characterGet.getIdCharacter());
        return new ResponseEntity<>(characterService.saveCharacter(character), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCharacter (@PathVariable(name = "id") Long id) {
        characterService.deleteCharacterById(id);
        return new ResponseEntity<>("Character removed successfully. Id= " + id, HttpStatus.OK );
    }
}
