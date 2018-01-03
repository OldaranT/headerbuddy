package com.xebia.headerbuddy.models.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "url")
public class Eurl {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String url;

    //Relations
    @ManyToOne
    @JoinColumn(name = "value_id")
    private Evalue value;
    @ManyToOne
    @JoinColumn(name = "report_id")
    private Ereport report;

    //Constructors
    public Eurl() {
        //Default Constructor.
    }

    public Eurl(final String url) {
        this.url = url;
    }

    public Eurl(final String url, final Evalue value) {
        this.url = url;
        this.value = value;
    }

    public Eurl(final String url, final Evalue value, final Ereport report) {
        this.url = url;
        this.value = value;
        this.report = report;
    }

    //Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Ereport getReport() {
        return report;
    }

    public void setReport(Ereport report) {
        this.report = report;
    }

    public Evalue getValue() {
        return value;
    }

    public void setValue(Evalue value) {
        this.value = value;
    }

}
