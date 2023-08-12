package services;

import dto.GenerateTicketRequest;
import exception.ParkingSpotNotFound;
import lombok.AllArgsConstructor;
import model.*;
import repositories.TicketRepository;
import statergy.spot_assigmnet_statergy.SpotAssigmentStrategy;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
public class TicketService {

    private GateService gateService;

    private VehicleService vehicleService;

    private ParkingLotService parkingLotService;
    private SpotAssigmentStrategy spotAssigmentStrategy;

    private TicketRepository ticketRepository;



    public Ticket generateTicket(int gateId,String vehicleRegistrationNumber, String vehicleType) throws ParkingSpotNotFound {
        // Step required to generate a ticket
        /*
        1. Get gate attendant
        2. Insert if not exists and get the vehicle object
        3. Figure out parking spot
            1] If no parking spot available, then throw an exception
        4. Generate the ticket object and store it in DB
         */

        Gate gate = gateService.getGate(gateId);
        VehicalType vehicalType = VehicalType.valueOf(vehicleType.toUpperCase());

        Vehicle vehicle = vehicleService.getOrInsertVehicle(vehicleRegistrationNumber,vehicalType);

        ParkingLot parkingLot = parkingLotService.getParkingLotByGateId(gateId);

        ParkingSpot parkingSpot = spotAssigmentStrategy.assignSpot(parkingLot,vehicalType);

        return ticketRepository.insertTicket(vehicle,parkingSpot, LocalDateTime.now(),gate);

    }

    public Ticket getTicketById(int ticketId){
        return ticketRepository.getTicketById(ticketId);
    }
}
