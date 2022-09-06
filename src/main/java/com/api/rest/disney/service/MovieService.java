package com.api.rest.disney.service;

import com.api.rest.disney.models.Movie;
import com.api.rest.disney.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Collection<Movie> findAll () {
        return (Collection<Movie>) movieRepository.findAll();
    }

    public Movie findMovieById (Long id) {
        return movieRepository.findById(id).orElseThrow();
    }

    public Optional<List<Movie>> findByTitle (String title) {
        return movieRepository.findByTitle(title);
    }

    public Movie saveMovie (Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovieById (Long id){
        movieRepository.deleteById(id);
    }
}
