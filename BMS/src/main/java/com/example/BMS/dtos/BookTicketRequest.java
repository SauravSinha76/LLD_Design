package com.example.BMS.dtos;


import lombok.Data;

import java.util.List;

@Data
public class BookTicketRequest {

    private int userId;
    private List<Integer> showSeatId;
}
