package pl.com.bottega.exchangerate.api;

import pl.com.bottega.exchangerate.domain.ExchangeRate;
import pl.com.bottega.exchangerate.domain.ExchangeRateQuery;

/**
 * Created by maciekdudek on 13.05.2017.
 */
public interface ExchangeRateCatalog {

    ExchangeRate get(ExchangeRateQuery query);
}
