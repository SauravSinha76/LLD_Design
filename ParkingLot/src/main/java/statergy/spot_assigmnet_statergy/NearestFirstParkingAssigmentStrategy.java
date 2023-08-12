package statergy.spot_assigmnet_statergy;

import exception.ParkingSpotNotFound;
import model.*;

public class NearestFirstParkingAssigmentStrategy implements SpotAssigmentStrategy{
    @Override
    public ParkingSpot assignSpot(ParkingLot parkingLot, VehicalType vehicalType) throws ParkingSpotNotFound {
        for (ParkingFloor parkingFloor : parkingLot.getParkingFloors()) {
            for (ParkingSpot parkingSpot : parkingFloor.getParkingSpots()) {
                if(parkingSpot.getVehicalType().equals(vehicalType) && parkingSpot.getSpotStatus().equals(SpotStatus.AVAILABLE)){
                    parkingSpot.setSpotStatus(SpotStatus.OCCUPIED);
                    return parkingSpot;
                }
            }
        }
        throw new ParkingSpotNotFound("No spot available for give VehicalType="+vehicalType.name());
    }
}
