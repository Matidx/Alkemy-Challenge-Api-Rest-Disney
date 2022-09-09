package com.api.rest.disney.service;

import com.api.rest.disney.exception.ResourceNotFoundException;
import com.api.rest.disney.models.Character;

import java.util.List;
import java.util.Optional;

public interface CharacterService {

    public List<Character> findAllCharacters ();

    public Character findCharacterById (Long id) throws ResourceNotFoundException;

    public Optional<List<Character>> findByWeightOrderByNameAsc (Double weight) throws ResourceNotFoundException;

    public Optional<List<Character>> findByAgeOrderByNameAsc (Integer age) throws ResourceNotFoundException;

    public Optional<List<Character>> findByName (String name) throws ResourceNotFoundException;

    public Character saveCharacter (Character character);

    public void deleteCharacterById (Long id);
}
