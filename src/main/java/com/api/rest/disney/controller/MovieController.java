package com.api.rest.disney.controller;

import com.api.rest.disney.models.Movie;
import com.api.rest.disney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/all")
    public ResponseEntity<Collection<Movie>> findAll (){
        return new ResponseEntity<>(movieService.findAll(), HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Movie> findMovieById (@PathVariable Long id){

        Movie movie = movieService.findMovieById(id);
        if (movie != null) {
            return new ResponseEntity<>(movieService.findMovieById(id),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Movie> saveMovie (@RequestBody Movie movie) {
        return new ResponseEntity<>(movieService.saveMovie(movie), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Movie> updateMovie (@PathVariable Long id, @RequestBody Movie movie) {
        Optional<Movie> optionalMovie = Optional.ofNullable(this.movieService.findMovieById(id));
        Movie movieGet = optionalMovie.get();
        movie.setIdMovie(movieGet.getIdMovie());
        return new ResponseEntity<>(movieService.saveMovie(movie), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMovie (@PathVariable(name = "id") Long id) {
        movieService.deleteMovieById(id);
        return new ResponseEntity<>("Movie removed successfully. Id= " + id, HttpStatus.OK );
    }
}
