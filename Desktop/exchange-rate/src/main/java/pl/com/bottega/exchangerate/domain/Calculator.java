package pl.com.bottega.exchangerate.domain;


import pl.com.bottega.exchangerate.api.ExchangeRateCatalog;
import pl.com.bottega.exchangerate.domain.commands.CalculateCommand;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
        ExchangeRate fromRate = prepareFromExchangeRate(cmd);
        ExchangeRate toRate = prepareToExchangeRate(cmd);
        BigDecimal calculatedAmount = (new BigDecimal(cmd.getAmount()).multiply(fromRate.getRate())).divide(toRate.getRate(), 2,
                RoundingMode.HALF_UP);
        return new CalculationResult(cmd.getFrom(), cmd.getTo(), new BigDecimal(cmd.getAmount()), calculatedAmount, cmd.getDate());
    }

    private CalculationResult calculateFrom(CalculateCommand cmd) {
        ExchangeRate exchangeRate = prepareFromExchangeRate(cmd);
        BigDecimal calculatedAmount = new BigDecimal(cmd.getAmount()).multiply(exchangeRate.getRate());
        return new CalculationResult(cmd.getFrom(), MAIN_CURRENCY, new BigDecimal(cmd.getAmount()), calculatedAmount, cmd.getDate());
    }

    private ExchangeRate prepareFromExchangeRate(CalculateCommand cmd) {
        ExchangeRateQuery exchangeRateQuery = new ExchangeRateQuery();
        exchangeRateQuery.setFrom(cmd.getFrom());
        exchangeRateQuery.setDate(cmd.getDate());
        return exchangeRateCatalog.get(exchangeRateQuery);
    }

    private CalculationResult calculateTo(CalculateCommand cmd) {
        ExchangeRate exchangeRate = prepareToExchangeRate(cmd);
        BigDecimal calculatedAmount = new BigDecimal(cmd.getAmount()).divide(exchangeRate.getRate(), 2, RoundingMode.HALF_UP);
        return new CalculationResult(MAIN_CURRENCY, cmd.getTo(), new BigDecimal(cmd.getAmount()), calculatedAmount, cmd.getDate());
    }

    private ExchangeRate prepareToExchangeRate(CalculateCommand cmd) {
        ExchangeRateQuery exchangeRateQuery = new ExchangeRateQuery();
        exchangeRateQuery.setTo(cmd.getTo());
        exchangeRateQuery.setDate(cmd.getDate());
        return exchangeRateCatalog.get(exchangeRateQuery);
    }
}
