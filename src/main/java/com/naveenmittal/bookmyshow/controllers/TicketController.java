package com.naveenmittal.bookmyshow.controllers;

import com.naveenmittal.bookmyshow.dtos.BookTicketRequestDto;
import com.naveenmittal.bookmyshow.dtos.BookTicketResponseDto;
import com.naveenmittal.bookmyshow.dtos.ResponseStatus;
import com.naveenmittal.bookmyshow.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.naveenmittal.bookmyshow.services.TicketService;

@Controller
public class TicketController {
    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public BookTicketResponseDto bookTicket(BookTicketRequestDto request) {
        BookTicketResponseDto response = new BookTicketResponseDto();
        try {
            Ticket ticket = ticketService.bookTicket(request.getUserId(), request.getShowId(), request.getSeatIds());
            response.setTicketId(ticket.getId());
            response.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            response.setStatus(ResponseStatus.FAILURE);
        }
        return response;
    }

}
