package com.example.BMS.controller;

import com.example.BMS.dtos.BookTicketRequest;
import com.example.BMS.exception.SeatSelectionException;
import com.example.BMS.exception.ShowNorFoundException;
import com.example.BMS.exception.UserNotFoundException;
import com.example.BMS.model.Ticket;
import com.example.BMS.services.ShowService;
import com.example.BMS.services.TicketService;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TicketController {

    private TicketService ticketService;
    public Ticket bookTicket(BookTicketRequest bookTicketRequest)  {
        try {

            validate(bookTicketRequest.getUserId(), bookTicketRequest.getShowSeatId());
            Ticket ticket = ticketService.bookTicket(bookTicketRequest.getUserId(), bookTicketRequest.getShowSeatId());

        }catch (SeatSelectionException| UserNotFoundException e){

        }
    }

    private void validate(int userId, List<Integer> showSeatIds) throws SeatSelectionException, UserNotFoundException {
        if(userId <0){
            throw new UserNotFoundException("The user id should be greater then 0.");
        }

        if( showSeatIds.size() == 0){
            throw new SeatSelectionException("The seat selected is 0");
        }
        if(showSeatIds.size() > 10){
            throw new SeatSelectionException("The seat selection is greater then 10");
        }
    }
}
