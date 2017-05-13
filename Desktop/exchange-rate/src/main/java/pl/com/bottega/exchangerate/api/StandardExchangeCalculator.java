package pl.com.bottega.exchangerate.api;


import pl.com.bottega.exchangerate.domain.CalculationResult;
import pl.com.bottega.exchangerate.domain.Calculator;
import pl.com.bottega.exchangerate.domain.commands.CalculateCommand;

public class StandardExchangeCalculator implements ExchangeCalculator{

    private Calculator calculator;

    public StandardExchangeCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public CalculationResult calculate(CalculateCommand cmd) {
        return calculator.calculate(cmd);
    }
}
