package pl.com.bottega.exchangerate.api;

import pl.com.bottega.exchangerate.domain.commands.AddExchangeRateCommand;

/**
 * Created by maciekdudek on 13.05.2017.
 */
public interface ExchangeRateManager {

    void addExchangeRate(AddExchangeRateCommand cmd);
}
