package pl.com.bottega.exchangerate.ui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.bottega.exchangerate.api.ExchangeCalculator;
import pl.com.bottega.exchangerate.domain.CalculationResult;
import pl.com.bottega.exchangerate.domain.commands.CalculateCommand;

import java.time.LocalDate;

@RestController
@RequestMapping("/calculation")
public class ExchangeCalculationController {

    private ExchangeCalculator exchangeCalculator;

    public ExchangeCalculationController(ExchangeCalculator exchangeCalculator) {
        this.exchangeCalculator = exchangeCalculator;
    }


    @GetMapping
    public CalculationResult calculate(CalculateCommand cmd) {
        return exchangeCalculator.calculate(cmd);
    }
}
