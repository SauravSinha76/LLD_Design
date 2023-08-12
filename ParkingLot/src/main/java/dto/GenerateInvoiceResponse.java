package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Invoice;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GenerateInvoiceResponse {
    private Invoice invoice;
    private InvoiceResponse response;

    public static GenerateInvoiceResponse getSuccessResponse(Invoice invoice){
        return new GenerateInvoiceResponse(invoice,new InvoiceResponse(ResponseStatus.SUCCESS,"Invoice is generated successfully."));
    }

    public static GenerateInvoiceResponse getFailureResponse(String message){
        GenerateInvoiceResponse response = new GenerateInvoiceResponse();
        response.setResponse(new InvoiceResponse(ResponseStatus.FAILED,message));
        return response;
    }

}
