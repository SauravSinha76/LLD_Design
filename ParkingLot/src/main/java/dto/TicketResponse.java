package dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TicketResponse {

    private String message;
    private ResponseStatus responseStatus;

    @Override
    public String toString() {
        return "TicketResponse{" +
                "message='" + message + '\'' +
                ", responseStatus=" + responseStatus +
                '}';
    }
}
