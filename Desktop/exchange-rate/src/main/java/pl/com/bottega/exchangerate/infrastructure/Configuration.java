package pl.com.bottega.exchangerate.infrastructure;

import org.springframework.context.annotation.Bean;
import pl.com.bottega.exchangerate.api.*;
import pl.com.bottega.exchangerate.domain.Calculator;
import pl.com.bottega.exchangerate.domain.ExchangeRateRepository;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public ExchangeCalculator exchangeCalculator() {
        return new StandardExchangeCalculator();
    }

    @Bean
    public ExchangeRateManager exchangeRateManager(ExchangeRateRepository exchangeRateRepository) {
        return new StandardExchangeRateManager(exchangeRateRepository);
    }

    @Bean
    public ExchangeRateRepository exchangeRateRepository() {
        return new JPAExchangeRateRepository();
    }

    @Bean
    public Calculator calculator(ExchangeRateCatalog exchangeRateCatalog) {
        return new Calculator(exchangeRateCatalog);
    }

    @Bean
    public ExchangeRateCatalog exchangeRateCatalog() {
        return new JPQLExchangeCatalog();
    }
}
