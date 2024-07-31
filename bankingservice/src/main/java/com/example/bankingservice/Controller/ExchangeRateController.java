package com.example.bankingservice.Controller;

import com.example.bankingservice.Model.ExchangeRate;
import com.example.bankingservice.Service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exchange_rates")
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @GetMapping
    public List<ExchangeRate> getExchangeRates() {
        return exchangeRateService.getAllExchangeRates();
    }

    @GetMapping("/{currencyPair}")
    public Optional<ExchangeRate> getExchangeRateByCurrencyPair(@PathVariable String currencyPair) {
        return exchangeRateService.getExchangeRateByPair(currencyPair);
    }

    @PostMapping
    public ExchangeRate createExchangeRate(@RequestBody ExchangeRate exchangeRate) {
        return exchangeRateService.createExchangeRate(exchangeRate);
    }

    @PutMapping("/{currencyPair}")
    public ExchangeRate updateExchangeRate(@PathVariable String currencyPair, @RequestBody ExchangeRate exchangeRate) {
        return exchangeRateService.updateExchangeRate(currencyPair, exchangeRate);
    }

    @DeleteMapping("/{currencyPair}")
    public void deleteExchangeRate(@PathVariable String currencyPair) {
        exchangeRateService.deleteExchangeRate(currencyPair);
    }
}
