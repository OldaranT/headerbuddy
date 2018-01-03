package com.xebia.headerbuddy.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRawValue;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "user")
public class Euser {

    @JsonIgnore
    @Id
    private String apikey;

    @NotNull
    private String email;

    //Relations
    @JsonIgnore
    @NotNull
    @Column(columnDefinition = "DATETIME")
    private Date creationdate;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Ereport> reports;

    //Constructors
    public Euser() {
        //Default Constructor.
    }

    public Euser( String email) {
        this.email = email;
    }

    public Euser( String aikey,  String email) {
        this.apikey = aikey;
        this.email = email;
    }

    //Getters and Setters
    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Set<Ereport> getReports() {
        return reports;
    }

    public void setReports(Set<Ereport> reports) {
        this.reports = reports;
    }

}
