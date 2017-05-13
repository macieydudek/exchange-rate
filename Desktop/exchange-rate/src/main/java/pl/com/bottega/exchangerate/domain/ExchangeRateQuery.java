package pl.com.bottega.exchangerate.domain;

public class ExchangeRateQuery {

    private String to;
    private String date;
    private String from;

    public String getTo() {
        return to;
    }

    public String getDate() {
        return date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
