package org.efrei.demo.models;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity

public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name= "firstname")
    private String firstname;

    public Actor(String name, String firstname){
        this.name=name;
        this.firstname=firstname;
    }
    public Actor(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
