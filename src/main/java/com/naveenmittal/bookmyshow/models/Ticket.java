package com.naveenmittal.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel {
    @ManyToMany
    private List<ShowSeat> showSeats;
    @ManyToOne
    private Show show;
    @ManyToOne
    private User user;
    private Long totalPrice;
}
