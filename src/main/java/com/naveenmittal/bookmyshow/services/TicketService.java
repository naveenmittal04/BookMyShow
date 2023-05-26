package com.naveenmittal.bookmyshow.services;

import com.naveenmittal.bookmyshow.exceptions.SeatNotAvailableException;
import com.naveenmittal.bookmyshow.exceptions.ShowNotFoundException;
import com.naveenmittal.bookmyshow.exceptions.ShowSeatBlockedException;
import com.naveenmittal.bookmyshow.exceptions.UserNotFoundException;
import com.naveenmittal.bookmyshow.models.*;
import com.naveenmittal.bookmyshow.repositories.ShowRepository;
import com.naveenmittal.bookmyshow.repositories.ShowSeatRepository;
import com.naveenmittal.bookmyshow.repositories.TicketRepository;
import com.naveenmittal.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private TicketRepository ticketRepository;
    private ShowSeatRepository showSeatRepository;

    private PriceCalculatorService priceCalculatorService;

    @Autowired
    public TicketService(UserRepository userRepository, ShowRepository showRepository, TicketRepository ticketRepository, ShowSeatRepository showSeatRepository, PriceCalculatorService priceCalculatorService) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.ticketRepository = ticketRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalculatorService = priceCalculatorService;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(Long userId, Long showId, List<Long> showSeatIds) {
        Optional<User> user = userRepository.findById(userId);
        if(!user.isPresent()) {
            throw new UserNotFoundException();
        }
        Optional<Show> show = showRepository.findById(showId);
        if(!show.isPresent()) {
            throw new ShowNotFoundException();
        }
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        for (ShowSeat showSeat: showSeats) {
            if(showSeat.getSeatStatus() == SeatStatus.BLOCKED && Duration.between(showSeat.getLastModifiedAt().toInstant(), Instant.now()).toMinutes() < 15) {
                throw new ShowSeatBlockedException();
            } else if(showSeat.getSeatStatus() != SeatStatus.AVAILABLE) {
                throw new SeatNotAvailableException();
            }
        }
        for (ShowSeat showSeat: showSeats) {
            showSeat.setSeatStatus(SeatStatus.BLOCKED);
            showSeatRepository.save(showSeat);
        }


        Ticket ticket = new Ticket();
        ticket.setShowSeats(showSeats);
        ticket.setShow(show.get());
        ticket.setUser(user.get());
        ticket.setTotalPrice(priceCalculatorService.CalculatePrice(showSeats));

        Ticket savedTicket = ticketRepository.save(ticket);

        return savedTicket;
    }
}
