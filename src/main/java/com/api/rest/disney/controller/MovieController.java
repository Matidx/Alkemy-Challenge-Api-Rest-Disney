package com.api.rest.disney.controller;

import com.api.rest.disney.models.Movie;
import com.api.rest.disney.service.implement.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieServiceImpl movieServiceImpl;

    @GetMapping("/all")
    public ResponseEntity<Collection<Movie>> findAllMovies (){
        return new ResponseEntity<>(movieServiceImpl.findAllMovies(), HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Optional<Movie>> findMovieById (@PathVariable Long id){
        return new ResponseEntity<>(movieServiceImpl.findMovieById(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> findByTitleOrIdGender (@RequestParam(value = "title", required = false) String title,
                                                    @RequestParam(value = "idGender", required = false) Long idGender) {
        if (title != null) {
            return ResponseEntity.status(HttpStatus.OK).body(movieServiceImpl.findByTitle(title));
        }
        if (idGender != null) {
            return ResponseEntity.status(HttpStatus.OK).body(movieServiceImpl.findGenderById(idGender));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can't find correct param");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/save")
    public ResponseEntity<Movie> saveMovie (@Valid @RequestBody Movie movie) {
        return new ResponseEntity<>(movieServiceImpl.saveMovie(movie), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<Movie> updateMovie (@PathVariable Long id,@Valid @RequestBody Movie movie) {
        Optional<Movie> optionalMovie = (this.movieServiceImpl.findMovieById(id));
        Movie movieGet = optionalMovie.get();
        movie.setIdMovie(movieGet.getIdMovie());
        movie.setCharacters(movieGet.getCharacters());
        return new ResponseEntity<>(movieServiceImpl.saveMovie(movie), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/updateCharacters/{id}")
    public ResponseEntity<Movie> updateMovieCharacters(@PathVariable Long id, @RequestBody Movie movie) {
        Optional<Movie> optionalPelicula = this.movieServiceImpl.findMovieById(id);
        Movie movieGet = optionalPelicula.get();
        movie.setIdMovie(movieGet.getIdMovie());
        movie.setUrlImage(movieGet.getUrlImage());
        movie.setCreationDate(movieGet.getCreationDate());
        movie.setQualification(movieGet.getQualification());
        movie.setTitle(movieGet.getTitle());

        return new ResponseEntity<>(movieServiceImpl.saveMovie(movie), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMovie (@PathVariable(name = "id") Long id) {
        movieServiceImpl.deleteMovieById(id);
        return new ResponseEntity<>("Movie removed successfully. Id= " + id, HttpStatus.OK );
    }
}
