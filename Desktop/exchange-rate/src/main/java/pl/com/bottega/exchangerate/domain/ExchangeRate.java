package pl.com.bottega.exchangerate.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class ExchangeRate {

    @Id
    Long id;

    private LocalDate date;
    private String currency;
    private BigDecimal rate;

    public ExchangeRate(String date, String currency, BigDecimal rate) {
        this.date = LocalDate.parse(date);
        this.currency = currency;
        this.rate = rate;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCurrency() {
        return currency;
    }
}
