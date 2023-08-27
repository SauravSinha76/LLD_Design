package com.example.BMS.repositories;

import com.example.BMS.model.Seat;
import com.example.BMS.model.Show;
import com.example.BMS.model.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Integer> {

    @Lock(value = LockModeType.PESSIMISTIC_READ)
    List<ShowSeat> findByIdInAndSeatStatus_Available(List<Integer> showSeatIds);
}
