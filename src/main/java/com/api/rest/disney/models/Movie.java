package com.api.rest.disney.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
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
    private String urlImage;

    private String title;

    @Column(name = "creation_date")
    @JsonFormat(pattern = "YYYY-MM-DD")
    private Date creationDate;

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

    public Set<com.api.rest.disney.models.Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<com.api.rest.disney.models.Character> characters) {
        this.characters = characters;
    }
}