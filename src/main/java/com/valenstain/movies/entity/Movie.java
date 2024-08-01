package com.valenstain.movies.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotBlank(message = "can't be blank")
    @Column(name = "name")
    private String name;
    @Column(name = "link")
    private String link;
    @Pattern(regexp = "\\d{2}:\\d{2} \\d{2}.\\d{2}.\\d{4}", message = "hh:mm dd.mm.yyyy")
    @Column(name = "start_time")
    private String startTime;
    @Column(name = "description")
    private String description;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "cat_id")
    private Category category;

    public Movie() {
    }

    public Movie(String name, String link, String startTime, String description, Category category) {
        this.name = name;
        this.link = link;
        this.startTime = startTime;
        this.description = description;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", startTime='" + startTime + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }
}
