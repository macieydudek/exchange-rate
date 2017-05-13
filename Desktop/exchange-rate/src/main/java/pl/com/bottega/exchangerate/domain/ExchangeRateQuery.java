package pl.com.bottega.exchangerate.domain;

public class ExchangeRateQuery {

    private final String to;
    private final String date;

    public ExchangeRateQuery(String to, String date) {
        this.to = to;
        this.date = date;
    }

    public String getTo() {
        return to;
    }

    public String getDate() {
        return date;
    }
}
