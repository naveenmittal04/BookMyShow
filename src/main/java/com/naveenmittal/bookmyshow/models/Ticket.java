package com.naveenmittal.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel {
    private List<ShowSeat> showSeats;
    private Show show;
    private User user;
    private Long totalPrice;
    public Ticket() {

    }
}
