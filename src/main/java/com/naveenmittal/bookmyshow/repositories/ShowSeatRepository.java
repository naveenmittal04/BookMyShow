package com.naveenmittal.bookmyshow.repositories;

import com.naveenmittal.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    @Override
    List<ShowSeat> findAllById(Iterable<Long> showSeatIds);

    @Override
    <S extends ShowSeat> List<S> saveAll(Iterable<S> entities);
}
