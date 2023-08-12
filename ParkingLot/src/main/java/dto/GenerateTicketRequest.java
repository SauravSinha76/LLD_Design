package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GenerateTicketRequest {

    private int gateId;
    private String vehicleRegistrationNumber;
    private String vehicleType;

}
