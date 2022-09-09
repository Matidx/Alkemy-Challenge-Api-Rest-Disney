package com.api.rest.disney.service.implement;

import com.api.rest.disney.exception.ResourceNotFoundException;
import com.api.rest.disney.models.Gender;
import com.api.rest.disney.repository.GenderRepository;
import com.api.rest.disney.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class GenderServiceImpl implements GenderService {

    @Autowired
    private GenderRepository genderRepository;

    public Collection<Gender> findAllGenders () {
        return (Collection<Gender>) genderRepository.findAll();
    }

    public Optional<Gender> findGenderById (Long idGender) throws ResourceNotFoundException {
        return Optional.ofNullable(genderRepository.findById(idGender).orElseThrow(() -> new ResourceNotFoundException("Gender", "id", idGender)));
    }
    public Gender saveGender (Gender gender) {
        return genderRepository.save(gender);
    }

    public void deleteGenderById (Long id){
        genderRepository.deleteById(id);
    }
}
