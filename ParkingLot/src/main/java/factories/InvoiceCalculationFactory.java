package factories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import statergy.Invoice_amount_calculation.InvoiceCalculationStrategy;
import statergy.Invoice_amount_calculation.WeekdayInvoiceCalculation;
import statergy.Invoice_amount_calculation.WeekendInvoiceCalculation;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class InvoiceCalculationFactory {

    private WeekendInvoiceCalculation weekendInvoiceCalculation;
    private WeekdayInvoiceCalculation weekdayInvoiceCalculation;

    public InvoiceCalculationStrategy getStrategy(LocalDateTime exitTime){
        DayOfWeek dayOfWeek = exitTime.getDayOfWeek();
        if(dayOfWeek.equals(DayOfWeek.SATURDAY) || dayOfWeek.equals(DayOfWeek.SUNDAY)){
            return weekendInvoiceCalculation;
        }
        else {
            return weekdayInvoiceCalculation;
        }
    }

}
