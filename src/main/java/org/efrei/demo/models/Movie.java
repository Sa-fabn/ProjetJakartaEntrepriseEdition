package org.efrei.demo.models;

import jakarta.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "lastname")
    private String lastname;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false) // Assure-toi que chaque film a une catégorie
    private Category category;

    // Constructeur avec category
    public Movie(String title, String lastname, Category category) {
        this.title = title;
        this.lastname = lastname;
        this.category = category;
    }

    // Constructeur par défaut
    public Movie() {}

    // Getters et setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

