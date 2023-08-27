package com.example.BMS.dtos;

import com.example.BMS.model.Ticket;
import lombok.Data;

@Data
public class BookTicketResponse {

    private Ticket ticket;
    private Response response;

    public BookTicketResponse() {
    }

    public static BookTicketResponse getSuccessResponse(Ticket ticket){
        BookTicketResponse bookTicketResponse = new BookTicketResponse();
        bookTicketResponse.ticket = ticket;
        bookTicketResponse.response = Response.getSuccessResponse("Ticket create successfully");
        return bookTicketResponse;
    }


}
