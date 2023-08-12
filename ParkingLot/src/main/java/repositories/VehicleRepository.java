package repositories;

import exception.VehicleNotFound;
import model.VehicalType;
import model.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {
    private Map<Integer, Vehicle> map;
    public static int id =1;
    public VehicleRepository() {
        map = new HashMap<>();
    }

    public Vehicle getVehicleByRegistrationNumber(String registrationNumber) throws VehicleNotFound {
        for (Map.Entry<Integer, Vehicle> vehicleEntry : map.entrySet()) {
            if(vehicleEntry.getValue().getRegistrationNumber().equals(registrationNumber)){
                return vehicleEntry.getValue();
            }
        }
        throw new VehicleNotFound("The vehicle belonging with "+registrationNumber+" is not found in system");
    }

    public Vehicle inserteVehicle(String registrationNumber, VehicalType vehicalType){
        id++;
        Vehicle vehicle = new Vehicle(id,registrationNumber,vehicalType);
        map.put(id,vehicle);
        return vehicle;
    }
}
