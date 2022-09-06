package com.api.rest.disney.service;

import com.api.rest.disney.models.Gender;
import com.api.rest.disney.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class GenderService {

    @Autowired
    private GenderRepository genderRepository;

    public Collection<Gender> findAll () {
        return (Collection<Gender>) genderRepository.findAll();
    }

    public Gender findGenderById (Long id) {
        return genderRepository.findById(id).orElseThrow();
    }

    public Gender saveGender (Gender gender) {
        return genderRepository.save(gender);
    }

    public void deleteGenderById (Long id){
        genderRepository.deleteById(id);
    }
}
