package controller;

import dto.GenerateInvoiceRequest;
import dto.GenerateInvoiceResponse;
import exception.TicketNotFound;
import lombok.AllArgsConstructor;
import model.Invoice;
import services.InvoiceService;

@AllArgsConstructor
public class InvoiceController {

    private InvoiceService invoiceService;

    public GenerateInvoiceResponse getInvoice(GenerateInvoiceRequest request){
        try {
            Invoice invoice = invoiceService.generateInvoice(request.getGateId(), request.getTicketId(),request.getExitTime());
            return GenerateInvoiceResponse.getSuccessResponse(invoice);
        } catch (TicketNotFound e) {
            return GenerateInvoiceResponse.getFailureResponse(e.getMessage());
        }
    }

}
