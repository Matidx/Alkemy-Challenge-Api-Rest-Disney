package com.api.rest.disney.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movie")
    private Long idMovie;

    @Column(name = "url_image")
    @NotEmpty(message = "The urlImage must not be empty or null")
    private String urlImage;

    @NotEmpty
    @Size(min = 2, message ="The title of the movie must have a minimum of 2 characters")
    private String title;

    @Column(name = "creation_date")
    @NotNull(message = "The creationDate must not be empty or null")
    @JsonFormat(pattern = "YYYY-MM-DD")
    private Date creationDate;

    @NotNull(message = "The rating of the film must be from 1 to 5")
    @Min(value = 1, message = "The rating of the film must be from 1 to 5")
    @Max(value = 5, message = "The rating of the film must be from 1 to 5")
    private Integer qualification;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "gender_id")
    private Gender genderId;

    @ManyToMany
    @JoinTable(name = "character_movie",joinColumns = @JoinColumn(name = "id_movie", referencedColumnName = "id_movie"),
            inverseJoinColumns = @JoinColumn(name = "id_character", referencedColumnName = "id_character"))
    private Set<Character> characters = new HashSet<>();

    public Long getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Long idMovie) {
        this.idMovie = idMovie;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getQualification() {
        return qualification;
    }

    public void setQualification(Integer qualification) {
        this.qualification = qualification;
    }

    public Gender getGenderId() {
        return genderId;
    }

    public void setGenderId(Gender genderId) {
        this.genderId = genderId;
    }

    public Set<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }
}