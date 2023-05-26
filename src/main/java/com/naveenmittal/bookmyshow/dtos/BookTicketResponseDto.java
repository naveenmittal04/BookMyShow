package com.naveenmittal.bookmyshow.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookTicketResponseDto {
    private ResponseStatus status;
    private Long ticketId;
    private Long ticketPrice;
}
