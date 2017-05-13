package pl.com.bottega.exchangerate.api;

import pl.com.bottega.exchangerate.domain.ExchangeRate;
import pl.com.bottega.exchangerate.domain.ExchangeRateQuery;

public interface ExchangeRateCatalog {

    ExchangeRate get(ExchangeRateQuery query);
}
