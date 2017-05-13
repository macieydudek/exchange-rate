package pl.com.bottega.exchangerate.api;

import pl.com.bottega.exchangerate.domain.CalculationResult;
import pl.com.bottega.exchangerate.domain.commands.CalculateCommand;

/**
 * Created by maciekdudek on 13.05.2017.
 */
public interface ExchangeCalculator {

    public CalculationResult calculate(CalculateCommand cmd);
}
