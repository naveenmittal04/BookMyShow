package com.naveenmittal.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketRequestDto {
    private RequestStatus status;
    private Long userId;
    private Long showId;
    private List<Long> seatIds;
}
