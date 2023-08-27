package com.example.BMS.repositories;

import com.example.BMS.model.SeatTypeShow;
import com.example.BMS.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatTypeShowRepository extends JpaRepository<SeatTypeShow, Integer> {

    public List<SeatTypeShow> findByShow(Show show);
}
