package pl.com.bottega.exchangerate.api;

import pl.com.bottega.exchangerate.domain.CalculationResult;
import pl.com.bottega.exchangerate.domain.commands.CalculateCommand;

public interface ExchangeCalculator {

    public CalculationResult calculate(CalculateCommand cmd);
}
