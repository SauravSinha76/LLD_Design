package controller;

import dto.GenerateTicketRequest;
import dto.GenerateTicketResponseDTO;
import exception.ParkingSpotNotFound;
import lombok.AllArgsConstructor;
import model.Ticket;
import services.TicketService;

@AllArgsConstructor
public class TicketController {

    private TicketService ticketService;


    public GenerateTicketResponseDTO generateTicket(GenerateTicketRequest dto){
        try {
            Ticket ticket = ticketService.generateTicket(dto.getGateId(), dto.getVehicleRegistrationNumber(), dto.getVehicleType());
            return GenerateTicketResponseDTO.getSuccessResponse(ticket);
        } catch (ParkingSpotNotFound e) {
            return GenerateTicketResponseDTO.getFailureResponse(e.getMessage());
        }
    }
}
