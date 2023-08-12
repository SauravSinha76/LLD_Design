package model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ParkingLot extends BaseModel{

    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;
    private String name;
    private String address;
    private Date openingTime;
    private Date closingTime;

    public ParkingLot(int id) {
        super(id);
    }
}
