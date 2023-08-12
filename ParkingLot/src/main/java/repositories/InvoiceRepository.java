package repositories;

import model.Gate;
import model.Invoice;
import model.ParkingAssistant;
import model.Ticket;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class InvoiceRepository {

    private Map<Integer, Invoice> map;
    private static int ID;

    public InvoiceRepository() {
        map = new HashMap<>();
    }

    public Invoice insertInvoice(Gate gate, LocalDateTime exitTime, ParkingAssistant parkingAssistant, Ticket ticket, double amount){
        ID++;
        Invoice invoice = new Invoice(ID,exitTime,ticket,gate,parkingAssistant,amount);
        map.put(ID,invoice);
        return invoice;
    }
}
