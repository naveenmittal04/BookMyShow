package com.naveenmittal.bookmyshow.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theater extends BaseModel{
    private String name;
    private String address;
    @OneToMany
    private List<Screen> screens;

    public Theater() {

    }

    public Theater(Long id) {
        super(id);
        //TODO Auto-generated constructor stub
    }
    
}
