package com.xebia.headerbuddy.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Is called Eheader because the class header already exists
@Entity // This tells Hibernate to make a table out of this class
public class Eheader
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;

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


}
