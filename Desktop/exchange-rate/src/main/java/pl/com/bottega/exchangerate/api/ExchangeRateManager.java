package pl.com.bottega.exchangerate.api;

import pl.com.bottega.exchangerate.domain.commands.AddExchangeRateCommand;

public interface ExchangeRateManager {

    void addExchangeRate(AddExchangeRateCommand cmd);
}
