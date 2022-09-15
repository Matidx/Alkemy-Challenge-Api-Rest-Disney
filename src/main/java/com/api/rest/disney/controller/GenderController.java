package com.api.rest.disney.controller;

import com.api.rest.disney.models.Gender;
import com.api.rest.disney.service.implement.GenderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/genders")
public class GenderController {

    @Autowired
    private GenderServiceImpl genderServiceImpl;

    @GetMapping("/all")
    public ResponseEntity<Collection<Gender>> findAll (){
        return new ResponseEntity<>(genderServiceImpl.findAllGenders(), HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Optional<Gender>> findGenderById (@PathVariable Long id){
            return new ResponseEntity<>(genderServiceImpl.findGenderById(id),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/save")
    public ResponseEntity<Gender> saveGender (@Valid @RequestBody Gender gender) {
        return new ResponseEntity<>(genderServiceImpl.saveGender(gender), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<Gender> updateGender (@PathVariable Long id,@Valid @RequestBody Gender gender) {
        Optional<Gender> optionalGender = (this.genderServiceImpl.findGenderById(id));
        Gender genderGet = optionalGender.get();
        gender.setIdGender(genderGet.getIdGender());
        gender.setMovies(genderGet.getMovies());
        return new ResponseEntity<>(genderServiceImpl.saveGender(gender), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGender (@PathVariable(name = "id") Long id) {
        genderServiceImpl.deleteGenderById(id);
        return new ResponseEntity<>("Gender removed successfully. Id= " + id, HttpStatus.OK );
    }
}
