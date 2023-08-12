package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Gate extends BaseModel{
    private String name;
    private GateStatus gateStatus;
    private GateType gateType;
    private ParkingAssistant parkingAssistant;

    public Gate(int id, String name, GateStatus gateStatus, GateType gateType, ParkingAssistant parkingAssistant) {
        super(id);
        this.name = name;
        this.gateStatus = gateStatus;
        this.gateType = gateType;
        this.parkingAssistant = parkingAssistant;
    }
}
