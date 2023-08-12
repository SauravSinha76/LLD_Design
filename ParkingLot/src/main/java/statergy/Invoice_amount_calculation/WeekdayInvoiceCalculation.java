package statergy.Invoice_amount_calculation;

import model.VehicalType;

import java.time.Duration;
import java.time.LocalDateTime;


public class WeekdayInvoiceCalculation implements InvoiceCalculationStrategy{
    @Override
    public double calculateAmount(LocalDateTime inTime, LocalDateTime exitTime, VehicalType vehicalType) {
        long hour = Duration.between(exitTime,inTime).toHours();
        return hour * 10;
    }
}
