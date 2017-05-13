package pl.com.bottega.exchangerate.domain.commands;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class AddExchangeRateCommand implements Validatable{

    private static final DateTimeFormatter CORRECT_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private String date;
    private String currency;
    private BigDecimal rate;

    public String getDate() {
        return date;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getRate() {
        return rate;
    }

    @Override
    public void validate(ValidationErrors errors) {
        validateDate(errors);
        validateCurrency(errors);
        validateRate(errors);
    }

    private void validateRate(ValidationErrors errors) {
        if (rate == null) {
            errors.add("rate", "is required");
        } else {
            checkIfPositive(errors);
        }
    }

    private void checkIfPositive(ValidationErrors errors) {
        if (rate.compareTo(BigDecimal.ZERO) != 1) {
            errors.add("rate", "must be > than 0.0");
        }
    }

    private void validateCurrency(ValidationErrors errors) {
        if (isEmpty(currency)) {
            errors.add("currency", "is required");
        } else {
            checkLength(errors);
        }

    }

    private void checkLength(ValidationErrors errors) {
        if (currency.length() != 3) {
            errors.add("currency", "has invalid format");
        }
    }

    private void validateDate(ValidationErrors errors) {
        if (isEmpty(date)) {
            errors.add("date", "is required");
        } else {
            checkDateFormat(errors);
        }
    }

    private void checkDateFormat(ValidationErrors errors) {
        try {
            LocalDate localDate = LocalDate.parse(date, CORRECT_DATE_FORMAT);
        } catch (DateTimeParseException ex) {
            errors.add("date", "Incorrect date format");
        }
    }
}
