package pl.com.bottega.exchangerate.ui;


import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.bottega.exchangerate.api.ExchangeRateManager;
import pl.com.bottega.exchangerate.domain.commands.AddExchangeRateCommand;

@RestController
@RequestMapping("/exchange-rate")
public class ExchangeRateController {

    private ExchangeRateManager exchangeRateManager;

    public ExchangeRateController(ExchangeRateManager exchangeRateManager) {
        this.exchangeRateManager = exchangeRateManager;

    }

    @PutMapping
    public void addExchangeRate(@RequestBody AddExchangeRateCommand cmd) {
        exchangeRateManager.addExchangeRate(cmd);
    }
}
