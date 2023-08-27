package com.example.BMS.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Ticket extends BaseModel{
    private List<Seat> seats;
    private Show show;
    private User user;
    private LocalDateTime startTime;
    private double price;
}
