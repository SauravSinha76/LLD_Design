package repositories;

import model.Gate;
import model.ParkingLot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotRepository {

    private final Map<Integer, ParkingLot> map;

    public ParkingLotRepository(Map<Integer, ParkingLot> map) {
        this.map = map;
    }

    public ParkingLotRepository() {
        map = new HashMap<>();
    }

    public ParkingLot getParkingLotByGateId(int gateId){
        for (Map.Entry<Integer, ParkingLot> integerParkingLotEntry : map.entrySet()) {
            for(Gate gate:integerParkingLotEntry.getValue().getGates()){
                if(gate.getId() == gateId){
                    return integerParkingLotEntry.getValue();
                }
            }
        }
        return null;
    }
}
