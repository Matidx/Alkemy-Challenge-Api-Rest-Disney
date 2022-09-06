package com.api.rest.disney.controller;

import com.api.rest.disney.models.Gender;
import com.api.rest.disney.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/genders")
public class GenderController {

    @Autowired
    private GenderService genderService;

    @GetMapping("/all")
    public ResponseEntity<Collection<Gender>> findAll (){
        return new ResponseEntity<>(genderService.findAll(), HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Gender> findGenderById (@PathVariable Long id){

        Gender gender =genderService.findGenderById(id);
        if (gender != null) {
            return new ResponseEntity<>(genderService.findGenderById(id),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Gender> saveGender (@RequestBody Gender gender) {
        return new ResponseEntity<>(genderService.saveGender(gender), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Gender> updateGender (@PathVariable Long id, @RequestBody Gender gender) {
        Optional<Gender> optionalGender = Optional.ofNullable(this.genderService.findGenderById(id));
        Gender genderGet = optionalGender.get();
        gender.setIdGender(genderGet.getIdGender());
        gender.setMovies(genderGet.getMovies());
        return new ResponseEntity<>(genderService.saveGender(gender), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGender (@PathVariable(name = "id") Long id) {
        genderService.deleteGenderById(id);
        return new ResponseEntity<>("Gender removed successfully. Id= " + id, HttpStatus.OK );
    }
}
