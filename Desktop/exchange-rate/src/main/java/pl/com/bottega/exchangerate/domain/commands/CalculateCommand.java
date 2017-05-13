package pl.com.bottega.exchangerate.domain.commands;


import java.time.LocalDate;

public class CalculateCommand implements Validatable{
    private LocalDate date;
    private String from;
    private String to;
    private Double amount;

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFrom() {
        return from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTo() {
        return to;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public void validate(ValidationErrors errors) {
        validateDate(errors);
        validateFrom(errors);
        validateTo(errors);

        if (from.equals(to)) {
            errors.add("from", "must be different than to");
            errors.add("to", "must be different than from");
            return;
        }

        validateAmount(errors);
    }

    private void validateAmount(ValidationErrors errors) {

    }

    private void validateTo(ValidationErrors errors) {

    }

    private void validateFrom(ValidationErrors errors) {

    }

    private void validateDate(ValidationErrors errors) {
    }
}
