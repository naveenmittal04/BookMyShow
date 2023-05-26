package com.naveenmittal.bookmyshow.services;

import com.naveenmittal.bookmyshow.models.ShowSeat;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculatorService {

    public Long CalculatePrice(List<ShowSeat> showSeats) {
        Long amount = 0L;

        for(ShowSeat showSeat: showSeats){
            amount += showSeat.getShowSeatType().getPrice();
        }
        return amount;
    }
}
