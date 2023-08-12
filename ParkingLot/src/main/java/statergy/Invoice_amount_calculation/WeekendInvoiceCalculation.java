package statergy.Invoice_amount_calculation;

import lombok.AllArgsConstructor;
import model.Slab;
import model.VehicalType;
import repositories.SlabRepository;
import services.SlabService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
public class WeekendInvoiceCalculation implements InvoiceCalculationStrategy{

    private SlabService slabService;
    @Override
    public double calculateAmount(LocalDateTime inTime, LocalDateTime exitTime, VehicalType vehicalType) {
        long hour = Duration.between(inTime,exitTime).toHours();
        List<Slab> slabs = slabService.getSlabsByVehicleType(vehicalType);
        double amount = 0;
        for (Slab slab : slabs) {
            if (hour > slab.getEndHour()){
                amount += slab.getPrice() *(slab.getEndHour() - slab.getStartHour());
            }
            else {
                amount += slab.getPrice() *(hour - slab.getStartHour());
                break;
            }
        }
        return amount;
    }
}
