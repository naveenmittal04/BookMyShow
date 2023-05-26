package com.naveenmittal.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class SeatType extends BaseModel{
    private List<String> seatTypes;
    public SeatType() {
        super();
    }
}
