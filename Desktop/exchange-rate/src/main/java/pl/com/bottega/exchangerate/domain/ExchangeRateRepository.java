package pl.com.bottega.exchangerate.domain;


public interface ExchangeRateRepository {

    public void put(ExchangeRate exchangeRate);

    ExchangeRate get(String date, String currency);

}
