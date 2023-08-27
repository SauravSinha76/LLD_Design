package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.InvoiceController;
import controller.TicketController;
import dto.GenerateInvoiceRequest;
import dto.GenerateInvoiceResponse;
import dto.GenerateTicketRequest;
import dto.GenerateTicketResponseDTO;
import factories.InvoiceCalculationFactory;
import model.*;
import repositories.*;
import services.*;
import statergy.Invoice_amount_calculation.WeekdayInvoiceCalculation;
import statergy.Invoice_amount_calculation.WeekendInvoiceCalculation;
import statergy.spot_assigmnet_statergy.NearestFirstParkingAssigmentStrategy;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );

        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.setParkingFloors(Arrays.asList(
                new ParkingFloor(1,
                        Arrays.asList(
                        new ParkingSpot(1,"A1", SpotStatus.AVAILABLE, VehicalType.SEDAN),
                        new ParkingSpot(1,"A2",SpotStatus.AVAILABLE,VehicalType.SEDAN)),
                        1,
                        "Floor 1",
                        FloorStatus.OPERATIONAL
                        )
                ));
        List<Gate> gates = Arrays.asList(new Gate(1,"G1",GateStatus.OPEN,GateType.ENTRY, new ParkingAssistant(1,"abc","efg")),
                    new Gate(2,"G2", GateStatus.OPEN,GateType.EXIT,new ParkingAssistant(2,"acs","hgashd"))
                );
        parkingLot.setGates(gates);
        parkingLot.setName("P1");
        parkingLot.setAddress("Jaipur");
        parkingLot.setOpeningTime(new Date());
        parkingLot.setClosingTime(new Date());
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository(new HashMap<>(){{
            put(1,parkingLot);
        }});
        Map<Integer,Gate> gateMap = new HashMap<>();
        for (Gate gate : gates) {
            gateMap.put(gate.getId(),gate);
        }
        GateRepository gateRepository = new GateRepository(gateMap);
        VehicleRepository vehicleRepository = new VehicleRepository();
        TicketRepository ticketRepository = new TicketRepository();


        ParkingLotService parkingLotService = new ParkingLotService(parkingLotRepository);
        GateService gateService = new GateService(gateRepository);
        VehicleService vehicleService = new VehicleService(vehicleRepository);
        TicketService ticketService = new TicketService(gateService,vehicleService,parkingLotService,new NearestFirstParkingAssigmentStrategy(),ticketRepository);
        TicketController controller = new TicketController(ticketService);
        GenerateTicketRequest generateTicketRequest = new GenerateTicketRequest(1,"RJ 14 1234",VehicalType.SEDAN.name());
        GenerateTicketResponseDTO dto = controller.generateTicket(generateTicketRequest);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();;
        System.out.println("Generating Ticket");
        System.out.println(gson.toJson(dto));


        HashMap<Integer,Slab> slabHashMap = new HashMap<>();
        slabHashMap.put(1,new Slab(1,0,2,20,VehicalType.SEDAN));
        slabHashMap.put(2,new Slab(2,2,4,25,VehicalType.SEDAN));
        slabHashMap.put(3,new Slab(3,4,6,30,VehicalType.SEDAN));
        slabHashMap.put(4,new Slab(4,6,8,35,VehicalType.SEDAN));
        slabHashMap.put(5,new Slab(5,8,10,40,VehicalType.SEDAN));
        SlabRepository slabRepository = new SlabRepository(new HashMap<Integer,Slab>(){{
            put(1,new Slab(1,0,2,20,VehicalType.SEDAN));
            put(2,new Slab(2,2,4,25,VehicalType.SEDAN));
            put(3,new Slab(3,4,6,30,VehicalType.SEDAN));
            put(4,new Slab(4,6,8,35,VehicalType.SEDAN));
            put(5,new Slab(5,8,10,40,VehicalType.SEDAN));
        }});
        SlabService slabService = new SlabService(slabRepository);
        InvoiceRepository invoiceRepository = new InvoiceRepository();
        InvoiceService invoiceService = new InvoiceService(invoiceRepository,gateService,ticketService,new InvoiceCalculationFactory(new WeekendInvoiceCalculation(slabService),new WeekdayInvoiceCalculation()));
        InvoiceController invoiceController = new InvoiceController(invoiceService);
        GenerateInvoiceRequest invoiceRequest = new GenerateInvoiceRequest(2,1, LocalDateTime.now().plusHours(7));
        GenerateInvoiceResponse invoiceResponse = invoiceController.getInvoice(invoiceRequest);
        System.out.println("Generating Invoice");
        System.out.println(gson.toJson(invoiceResponse));
    }
}
