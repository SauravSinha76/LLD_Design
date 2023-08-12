package services;

import lombok.AllArgsConstructor;
import model.ParkingLot;
import repositories.ParkingLotRepository;

@AllArgsConstructor
public class ParkingLotService {

    private ParkingLotRepository repository;
    public ParkingLot getParkingLotByGateId(int gateId){
        return repository.getParkingLotByGateId(gateId);
    }
}
