package com.api.rest.disney.service;

import com.api.rest.disney.exception.ResourceNotFoundException;
import com.api.rest.disney.models.Gender;
import com.api.rest.disney.models.Movie;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface MovieService {

    public Collection<Movie> findAllMovies ();

    public Optional<Movie> findMovieById (Long id) throws ResourceNotFoundException;

    public List<Movie> findByTitle (String title) throws ResourceNotFoundException;

    public Optional<Gender> findGenderById (Long idGender) throws ResourceNotFoundException;

    public Movie saveMovie (Movie movie);

    public void deleteMovieById (Long id);
}
