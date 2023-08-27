package com.example.BMS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class SeatTypeShow extends BaseModel{
    @Enumerated(value = EnumType.ORDINAL)
    private SeatType seatType;
    @ManyToOne
    private Show show;
    private double price;
}
