package statergy.Invoice_amount_calculation;

import model.VehicalType;

import java.time.LocalDateTime;

public interface InvoiceCalculationStrategy {

    public double calculateAmount(LocalDateTime inTime, LocalDateTime exitTime, VehicalType vehicalType);
}
