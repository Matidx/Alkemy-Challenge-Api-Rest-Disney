package com.api.rest.disney.service;

import com.api.rest.disney.exception.ResourceNotFoundException;
import com.api.rest.disney.models.Gender;

import java.util.Collection;
import java.util.Optional;

public interface GenderService {

    public Collection<Gender> findAllGenders ();

    public Optional<Gender> findGenderById (Long id) throws ResourceNotFoundException;

    public Gender saveGender (Gender gender);

    public void deleteGenderById (Long id);
}
