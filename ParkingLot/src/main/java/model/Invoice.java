package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Invoice extends BaseModel{
    private LocalDateTime exitTime;
    private Ticket ticket;
    private Gate exitGate;
    private ParkingAssistant parkingAssistant;
    private double amount;

    public Invoice(int id, LocalDateTime exitTime, Ticket ticket, Gate exitGate,ParkingAssistant parkingAssistant,double amount) {
        super(id);
        this.exitTime = exitTime;
        this.ticket = ticket;
        this.exitGate = exitGate;
        this.parkingAssistant = parkingAssistant;
        this.amount = amount;
    }





}
