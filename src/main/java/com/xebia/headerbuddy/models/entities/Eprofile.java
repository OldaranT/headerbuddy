package com.xebia.headerbuddy.models.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "profile")
public class Eprofile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String name;

    //Relations
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Eheader> headers;

    //Constructors
    public Eprofile() {

    }

    public Eprofile(String name) {
        this.name = name;
    }

    public Eprofile(String name, Set<Eheader> headers) {
        this.name = name;
        this.headers = headers;
    }

    //Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Eheader> getHeaders() {
        return headers;
    }

    public void setHeaders(Set<Eheader> headers) {
        this.headers = headers;
    }

}
