package pl.com.bottega.exchangerate.api;


import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.exchangerate.domain.ExchangeRate;
import pl.com.bottega.exchangerate.domain.ExchangeRateRepository;
import pl.com.bottega.exchangerate.domain.commands.AddExchangeRateCommand;

public class StandardExchangeRateManager implements ExchangeRateManager {

    private ExchangeRateRepository exchangeRateRepository;

    public StandardExchangeRateManager(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }

    @Override
    @Transactional
    public void addExchangeRate(AddExchangeRateCommand cmd) {
        ExchangeRate exchangeRate = exchangeRateRepository.get(cmd.getDate(), cmd.getCurrency());
        if (exchangeRate != null) {
            exchangeRate.setRate(cmd.getRate());
        } else {
            exchangeRate = new ExchangeRate(cmd.getDate(), cmd.getCurrency(), cmd.getRate());
            exchangeRateRepository.put(exchangeRate);
        }
    }
}
