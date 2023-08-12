package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle extends BaseModel{
    private String registrationNumber;
    private VehicalType vehicalType;

    public Vehicle(int id,String registrationNumber, VehicalType vehicalType) {
        super(id);
        this.registrationNumber = registrationNumber;
        this.vehicalType = vehicalType;
    }

}
