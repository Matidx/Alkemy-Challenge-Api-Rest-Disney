package com.api.rest.disney.service;

import com.api.rest.disney.models.Character;
import com.api.rest.disney.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;

    public Collection<Character> findAll () {
        return (Collection<Character>) characterRepository.findAll();
    }

    public Character findCharacterById (Long id) {
        return characterRepository.findById(id).orElseThrow();
    }

    public Optional<List<Character>> findByWeightOrderByNameAsc (Double weight) {
        return characterRepository.findByWeightOrderByNameAsc(weight);
    }

    public Optional<List<Character>> findByAgeOrderByNameAsc (Integer age) {
        return characterRepository.findByAgeOrderByNameAsc(age);
    }

    public Optional<List<Character>> findByName (String name) {
        return characterRepository.findByName(name);
    }

    public Character saveCharacter (Character character) {
        return characterRepository.save(character);
    }
    public void deleteCharacterById (long id){
        characterRepository.deleteById(id);
    }
}
