package com.example.BMS.services;

import com.example.BMS.exception.SeatSelectionException;
import com.example.BMS.exception.UserNotFoundException;
import com.example.BMS.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TicketService {

    Ticket bookTicket(int userId, List<Integer> showSeatId) throws UserNotFoundException, SeatSelectionException;
}
