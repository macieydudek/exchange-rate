package pl.com.bottega.exchangerate.domain;


import pl.com.bottega.exchangerate.api.ExchangeRateCatalog;
import pl.com.bottega.exchangerate.domain.commands.CalculateCommand;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Calculator {

    private ExchangeRateCatalog exchangeRateCatalog;

    private static final String MAIN_CURRENCY = "PLN";

    public Calculator(ExchangeRateCatalog exchangeRateCatalog) {
        this.exchangeRateCatalog = exchangeRateCatalog;
    }


    public CalculationResult calculate(CalculateCommand cmd) {
        if (cmd.getFrom().equals(MAIN_CURRENCY)) {
            return calculateTo(cmd);
        } else if (cmd.getTo().equals(MAIN_CURRENCY)) {
            return calculateFrom(cmd);
        }
        return calculateFromTo(cmd);
    }

    private CalculationResult calculateFromTo(CalculateCommand cmd) {

        return null;
    }

    private CalculationResult calculateFrom(CalculateCommand cmd) {
        return null;
    }

    private CalculationResult calculateTo(CalculateCommand cmd) {
        ExchangeRateQuery exchangeRateQuery = new ExchangeRateQuery(cmd.getTo(), cmd.getDate().toString());
        ExchangeRate exchangeRate = exchangeRateCatalog.get(exchangeRateQuery);
        BigDecimal calculatedAmount = new BigDecimal(cmd.getAmount()).multiply(exchangeRate.getRate());
        LocalDate date = exchangeRate.getDate();
        return new CalculationResult(MAIN_CURRENCY, cmd.getTo(), new BigDecimal(cmd.getAmount()), calculatedAmount, date);
    }
}
