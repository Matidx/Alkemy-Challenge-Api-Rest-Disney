package com.api.rest.disney.repository;

import com.api.rest.disney.models.Character;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepository extends CrudRepository <Character, Long> {

    Optional<List<Character>> findByWeightOrderByNameAsc(Double weight);

    Optional<List<Character>> findByName(String name);

    Optional<List<Character>> findByAgeOrderByNameAsc(Integer age);
}
