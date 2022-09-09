package com.api.rest.disney.service.implement;

import com.api.rest.disney.exception.ResourceNotFoundException;
import com.api.rest.disney.models.Character;
import com.api.rest.disney.repository.CharacterRepository;
import com.api.rest.disney.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService {
    @Autowired
    private CharacterRepository characterRepository;

    public List<Character> findAllCharacters () {
        return (List<Character>) characterRepository.findAll();
    }

    public Character findCharacterById (Long id) throws ResourceNotFoundException {
        return characterRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Character", "id", id));
    }

    public Optional<List<Character>> findByWeightOrderByNameAsc (Double weight) throws ResourceNotFoundException {
        try {
            return characterRepository.findByWeightOrderByNameAsc(weight);
        } catch (ResourceNotFoundException exception) {
            throw new ResourceNotFoundException("Character", "weight", weight);
        }
    }

    public Optional<List<Character>> findByAgeOrderByNameAsc (Integer age) throws ResourceNotFoundException {
        try {
            return characterRepository.findByAgeOrderByNameAsc(age);
        } catch (ResourceNotFoundException exception) {
            throw new ResourceNotFoundException("Character", "age", age);
        }
    }

    public Optional<List<Character>> findByName (String name) throws ResourceNotFoundException {
        try {
            return characterRepository.findByName(name);
        } catch (ResourceNotFoundException exception) {
            throw new ResourceNotFoundException("Character", "name", name);
        }
    }
    public Character saveCharacter (Character character) {
        return characterRepository.save(character);
    }
    public void deleteCharacterById (Long id){
        characterRepository.deleteById(id);
    }
}
