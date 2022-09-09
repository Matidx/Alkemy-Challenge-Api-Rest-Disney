package com.api.rest.disney.service.implement;

import com.api.rest.disney.exception.ResourceNotFoundException;
import com.api.rest.disney.models.Gender;
import com.api.rest.disney.models.Movie;
import com.api.rest.disney.repository.GenderRepository;
import com.api.rest.disney.repository.MovieRepository;
import com.api.rest.disney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private GenderRepository genderRepository;

    public Collection<Movie> findAllMovies () {
        return movieRepository.findAll();
    }

    public Optional<Movie> findMovieById (Long id) throws ResourceNotFoundException {
        return Optional.ofNullable(movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie", "id", id)));
    }

    public List<Movie> findByTitle (String title) throws ResourceNotFoundException {
        try {
            return movieRepository.findByTitle(title);
        } catch (ResourceNotFoundException exception) {
            throw new ResourceNotFoundException("Movie", "title", title);
        }
    }

    public Optional<Gender> findGenderById (Long idGender) throws ResourceNotFoundException {
            return Optional.ofNullable(genderRepository.findById(idGender).orElseThrow(() -> new ResourceNotFoundException("Gender", "id", idGender)));
    }

    public Movie saveMovie (Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovieById (Long id){
        movieRepository.deleteById(id);
    }
}
