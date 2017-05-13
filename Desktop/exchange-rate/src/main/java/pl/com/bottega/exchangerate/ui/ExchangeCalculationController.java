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

    ExchangeCalculator exchangeCalculator;


    @GetMapping
    public CalculationResult calculate(@PathVariable String date, @PathVariable String from, @PathVariable String to, @PathVariable
            Double amount) {
        CalculateCommand cmd = new CalculateCommand();
        cmd.setDate(LocalDate.parse(date));
        cmd.setFrom(from);
        cmd.setTo(to);
        cmd.setAmount(amount);
        return exchangeCalculator.calculate(cmd);
    }
}
