package com.xebia.headerbuddy.models.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "url")
public class Eurl {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String url;

    //Relations
    @ManyToOne
    @JoinColumn(name="report_id")
    public Ereport report;
    @ManyToOne
    @JoinColumn(name="value_id")
    public Evalue value;

    public Integer getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
