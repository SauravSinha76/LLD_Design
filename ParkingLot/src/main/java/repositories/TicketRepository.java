package repositories;

import model.Gate;
import model.ParkingSpot;
import model.Ticket;
import model.Vehicle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class TicketRepository {

    Map<Integer, Ticket> map;
    private static int ID = 0;

    public TicketRepository() {
        map = new HashMap<>();
    }

    public Ticket insertTicket(Vehicle vehicle, ParkingSpot parkingSpot, LocalDateTime inTime, Gate gate){
        ID++;
        Ticket ticket = new Ticket(ID);
        ticket.setInTime(inTime);
        ticket.setVehicle(vehicle);
        ticket.setParkingSpot(parkingSpot);
        ticket.setParkingAssistant(gate.getParkingAssistant());
        ticket.setInGate(gate);
        map.put(ID,ticket);
        return ticket;
    }

    public Ticket getTicketById(int ticketId){
        return map.get(ticketId);
    }
}
