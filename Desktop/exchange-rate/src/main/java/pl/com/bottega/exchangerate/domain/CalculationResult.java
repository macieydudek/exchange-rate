package pl.com.bottega.exchangerate.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CalculationResult {
    String from;
    String to;
    BigDecimal amount;
    BigDecimal calculatedAmount;
    LocalDate date;

    public CalculationResult(String from, String to, BigDecimal amount, BigDecimal calculatedAmount, LocalDate date) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.calculatedAmount = calculatedAmount;
        this.date = date;
    }
}
