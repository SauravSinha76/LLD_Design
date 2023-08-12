package model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ParkingFloor extends BaseModel{

    private List<ParkingSpot> parkingSpots;
    private int floorNumber;
    private String floorName;
    private FloorStatus floorStatus;

    public ParkingFloor(int id, List<ParkingSpot> parkingSpots, int floorNumber, String floorName, FloorStatus floorStatus) {
        super(id);
        this.parkingSpots = parkingSpots;
        this.floorNumber = floorNumber;
        this.floorName = floorName;
        this.floorStatus = floorStatus;
    }
}
