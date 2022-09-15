package com.api.rest.disney.repository;

import com.api.rest.disney.models.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

    Collection<Movie> findAll();

    List<Movie> findByTitle(String title);
}
