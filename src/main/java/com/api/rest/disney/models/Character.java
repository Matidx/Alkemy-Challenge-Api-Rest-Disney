package com.api.rest.disney.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "characters")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_character")
    private Long idCharacter;

    @Column(name = "url_image")
    @NotEmpty(message = "The urlImage must not be empty or null")
    private String urlImage;

    @NotEmpty
    @Size(min = 2, message ="The name of the character must have a minimum of 2 characters")
    private String name;

    @NotNull(message = "The age must not be empty or null")
    private Integer age;

    @NotNull(message = "The weight must not be empty or null")
    private Double weight;

    @NotEmpty(message = "The history must not be empty or null")
    @Size(min = 10, message = "The history of the character must have a minimum of 10 characters")
    private String history;

    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "character_movie",joinColumns = @JoinColumn(name = "id_character", referencedColumnName = "id_character"),
            inverseJoinColumns = @JoinColumn(name = "id_movie", referencedColumnName = "id_movie"))
    private Set<Movie> movies = new HashSet<>();

    public Long getIdCharacter() {
        return idCharacter;
    }

    public void setIdCharacter(Long idCharacter) {
        this.idCharacter = idCharacter;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}