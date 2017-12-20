package com.xebia.headerbuddy.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "report")
public class Ereport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private int id;
    @NotNull
    @Column(columnDefinition = "DATETIME")
    private Date date;

    //Relations
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Euser user;

    @ManyToMany
    private Set<Evalue> values;

    @OneToMany(mappedBy = "report")
    @JsonIgnore
    private Set<Eurl> urls;

    //Constructors
    public Ereport(){

    }

    public Ereport(Euser user, Set<Evalue> values){
        date = new Date();
        this.user = user;
        this.values = values;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Evalue> getValues() {
        return values;
    }

    public void setValues(Set<Evalue> values) {
        this.values = values;
    }

    public Euser getUser() {
        return user;
    }

    public void setUser(Euser user) {
        this.user = user;
    }

    public Set<Eurl> getUrls() {
        return urls;
    }

    public void setUrls(Set<Eurl> urls) {
        this.urls = urls;
    }

}
