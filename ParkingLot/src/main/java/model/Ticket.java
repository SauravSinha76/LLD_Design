package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class Ticket extends BaseModel{
    private LocalDateTime inTime;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private ParkingAssistant parkingAssistant;
    private Gate inGate;

    public Ticket(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "inTime=" + inTime +
                ", vehicle=" + vehicle +
                ", parkingSpot=" + parkingSpot +
                ", parkingAssistant=" + parkingAssistant +
                ", inGate=" + inGate +
                '}';
    }
}
