package com.naveenmittal.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private int seatNumber;
    private int seatRowNumber;
    private int seatColumnNumber;
    @ManyToOne
    private SeatType seatType;

    public Seat(Long id, int seatNumber, SeatType seatType) {
        super(id);
        this.seatNumber = seatNumber;
        this.seatRowNumber = 0;
        this.seatColumnNumber = 0;
        this.seatType = seatType;
    }

    public Seat() {
        super();
    }
}
