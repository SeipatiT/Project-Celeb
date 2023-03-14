package com.example.projectceleb.Entity;


import jakarta.persistence.*;


@Entity
@Table(name = "celebs")
public class Celeb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "movie_title")
    private String movieTitle;

    public Celeb(){}


    public Celeb(String firstName, String lastName, String movieTitle) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.movieTitle = movieTitle;
    }


    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }
}
