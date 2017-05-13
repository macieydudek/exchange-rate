package pl.com.bottega.exchangerate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class ExchangeRate {

    @Id
    @GeneratedValue
    private Long id;

    private String date;
    private String currency;
    private BigDecimal rate;

    public ExchangeRate(String date, String currency, BigDecimal rate) {
        this.date = date;
        this.currency = currency;
        this.rate = rate;
    }

    ExchangeRate() {
    }

    public BigDecimal getRate() {
        return rate;
    }

    public String getDate() {
        return date;
    }

    public String getCurrency() {
        return currency;
    }

    public Long getId() {
        return id;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
