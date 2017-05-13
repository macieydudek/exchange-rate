package pl.com.bottega.exchangerate.api;


import pl.com.bottega.exchangerate.domain.CalculationResult;
import pl.com.bottega.exchangerate.domain.Calculator;
import pl.com.bottega.exchangerate.domain.commands.CalculateCommand;

public class StandardExchangeCalculator implements ExchangeCalculator{

    Calculator calculator;

    @Override
    public CalculationResult calculate(CalculateCommand cmd) {
        return calculator.calculate(cmd);
    }
}
