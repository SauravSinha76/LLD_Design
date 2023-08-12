package statergy.spot_assigmnet_statergy;

import exception.ParkingSpotNotFound;
import model.ParkingLot;
import model.ParkingSpot;
import model.VehicalType;

public interface SpotAssigmentStrategy {

    ParkingSpot assignSpot(ParkingLot parkingLot, VehicalType vehicalType) throws ParkingSpotNotFound;
}
