package services;

import exception.VehicleNotFound;
import lombok.AllArgsConstructor;
import model.VehicalType;
import model.Vehicle;
import repositories.VehicleRepository;

@AllArgsConstructor
public class VehicleService {
    private VehicleRepository vehicleRepository;
    public Vehicle getOrInsertVehicle(String vehicleRegistrationNumber, VehicalType vehicalType){
        Vehicle vehicle = null;
        try {
            vehicle = vehicleRepository.getVehicleByRegistrationNumber(vehicleRegistrationNumber);
        } catch (VehicleNotFound e) {
            vehicle = vehicleRepository.inserteVehicle(vehicleRegistrationNumber,vehicalType);
        }
        return vehicle;
    }
}
