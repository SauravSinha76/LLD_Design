package model;

import lombok.Getter;

@Getter
public class Slab extends BaseModel{
    private int startHour;
    private int endHour;
    private double price;
    private VehicalType vehicalType;


    public Slab(int id, int startHour, int endHour, double price, VehicalType vehicalType) {
        super(id);
        this.startHour = startHour;
        this.endHour = endHour;
        this.price = price;
        this.vehicalType = vehicalType;
    }
}
