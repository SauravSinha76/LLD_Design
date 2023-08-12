package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingAssistant extends BaseModel{
    private String name;
    private String email;

    public ParkingAssistant(int id, String name, String email) {
        super(id);
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "ParkingAssistant{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
