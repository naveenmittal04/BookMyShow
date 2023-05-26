package com.naveenmittal.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseModel{
    private String name;
    private String email;
    private String password;
    private Long phoneNumber;
    @OneToMany
    private List<Ticket> tickets;

    public User() {

    }
}
