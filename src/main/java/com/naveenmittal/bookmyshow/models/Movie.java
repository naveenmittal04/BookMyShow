package com.naveenmittal.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String name;
    @ManyToMany
    private List<Actor> cast;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<MovieLanguage> languages;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;

    public Movie() {

    }
}
