package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class InvoiceResponse {
    private ResponseStatus responseStatus;
    private String message;
}
