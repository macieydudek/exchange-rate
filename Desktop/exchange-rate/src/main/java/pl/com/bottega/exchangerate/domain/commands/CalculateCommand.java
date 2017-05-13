package pl.com.bottega.exchangerate.domain.commands;

public class CalculateCommand implements Validatable{
    private String date;
    private String from;
    private String to;
    private Double amount;

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
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
        validateAmount(errors);
    }

    private void validateAmount(ValidationErrors errors) {
        if (amount == null) {
            errors.add("amount", "is required");
        }
    }

    private void validateTo(ValidationErrors errors) {
        if (to == null) {
            errors.add("to", "is required");
        }
    }

    private void validateFrom(ValidationErrors errors) {
        if (from == null) {
            errors.add("from", "is required");
        } else {
            validateNotSameAsTo(errors);
        }

    }

    private void validateNotSameAsTo(ValidationErrors errors) {
        if (from.equals(to)) {
            errors.add("from", "must be different than to");
            errors.add("to", "must be different than from");
        }
    }

    private void validateDate(ValidationErrors errors) {
        if (date == null) {
            errors.add("date", "is required");
        }
    }
}
