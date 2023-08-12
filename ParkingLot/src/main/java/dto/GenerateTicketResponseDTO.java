package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Ticket;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenerateTicketResponseDTO {

    private Ticket ticket;
    private TicketResponse response;

    public static GenerateTicketResponseDTO getSuccessResponse(Ticket ticket){
        return new GenerateTicketResponseDTO(ticket,new TicketResponse("Ticket generated successfully",ResponseStatus.SUCCESS));
    }
    public static GenerateTicketResponseDTO getFailureResponse(String message){
        GenerateTicketResponseDTO dto = new GenerateTicketResponseDTO();
        dto.setResponse(new TicketResponse("Ticket generates as failed with message :"+message,ResponseStatus.FAILED));
        return dto;
    }

    @Override
    public String toString() {
        return "GenerateTicketResponseDTO{" +
                "ticket=" + ticket +
                ", response=" + response +
                '}';
    }
}
