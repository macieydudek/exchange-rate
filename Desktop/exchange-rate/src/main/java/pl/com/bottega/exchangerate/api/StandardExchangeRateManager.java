package pl.com.bottega.exchangerate.api;


import pl.com.bottega.exchangerate.domain.ExchangeRate;
import pl.com.bottega.exchangerate.domain.ExchangeRateRepository;
import pl.com.bottega.exchangerate.domain.commands.AddExchangeRateCommand;

public class StandardExchangeRateManager implements ExchangeRateManager {

    private ExchangeRateRepository exchangeRateRepository;

    public StandardExchangeRateManager(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    @Override
    public void addExchangeRate(AddExchangeRateCommand cmd) {
        ExchangeRate exchangeRate = new ExchangeRate(cmd.getDate(), cmd.getCurrency(), cmd.getRate());

    }
}
