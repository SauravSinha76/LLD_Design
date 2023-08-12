package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class GenerateInvoiceRequest {

    private int gateId;
    private int ticketId;
    private LocalDateTime exitTime;


}
