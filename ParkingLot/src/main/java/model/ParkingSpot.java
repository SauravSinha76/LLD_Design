package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSpot extends BaseModel {

    private String name;
    private SpotStatus spotStatus;
    private VehicalType vehicalType;

    public ParkingSpot(int id, String name, SpotStatus spotStatus, VehicalType vehicalType) {
        super(id);
        this.name = name;
        this.spotStatus = spotStatus;
        this.vehicalType = vehicalType;
    }


}
