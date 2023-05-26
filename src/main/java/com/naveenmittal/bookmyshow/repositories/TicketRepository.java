package com.naveenmittal.bookmyshow.repositories;

import com.naveenmittal.bookmyshow.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{
    @Override
    <S extends Ticket> S save(S entity);
}
