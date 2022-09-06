package com.api.rest.disney.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genders")
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gender")
    private Long idGender;

    private String name;

    @Column(name = "url_image")
    private String urlImage;

    @OneToMany(mappedBy = "genderId", cascade = CascadeType.ALL)
    private Set<com.api.rest.disney.models.Movie> movies = new HashSet<>();

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

    public Set<com.api.rest.disney.models.Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<com.api.rest.disney.models.Movie> movies) {
        this.movies = movies;
    }
}