package com.api.rest.disney.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genders")
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gender")
    private Long idGender;

    @NotEmpty
    @Size(min = 2, message ="The name of the gender must have a minimum of 2 characters")
    private String name;

    @Column(name = "url_image")
    @NotEmpty(message = "The urlImage must not be empty or null")
    private String urlImage;

    @OneToMany(mappedBy = "genderId", cascade = CascadeType.ALL)
    private Set<Movie> movies = new HashSet<>();

    public Long getIdGender() {
        return idGender;
    }

    public void setIdGender(Long idGender) {
        this.idGender = idGender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
