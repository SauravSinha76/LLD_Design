package services;

import exception.TicketNotFound;
import factories.InvoiceCalculationFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import model.Gate;
import model.Invoice;
import model.Ticket;
import repositories.InvoiceRepository;
import statergy.Invoice_amount_calculation.InvoiceCalculationStrategy;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class InvoiceService {
    private InvoiceRepository invoiceRepository;
    private GateService gateService;
    private TicketService ticketService;
    private InvoiceCalculationFactory factory;
    public Invoice generateInvoice(int gateId, int ticketId,LocalDateTime exitTime) throws TicketNotFound {
        Gate gate = gateService.getGate(gateId);

        Ticket ticket = ticketService.getTicketById(ticketId);
        if(ticket == null){
            throw new TicketNotFound("The ticket corresponding to ticket id :"+ticketId+"is not found in the system");
        }
        InvoiceCalculationStrategy invoiceCalculationStrategy = factory.getStrategy(exitTime);

        double amount = invoiceCalculationStrategy.calculateAmount(ticket.getInTime(),exitTime,ticket.getVehicle().getVehicalType());

        return invoiceRepository.insertInvoice(gate,exitTime,gate.getParkingAssistant(),ticket,amount);

    }
}
