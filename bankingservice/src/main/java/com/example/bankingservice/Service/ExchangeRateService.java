package com.example.bankingservice.Service;

import com.example.bankingservice.Model.ExchangeRate;
import com.example.bankingservice.Repository.ExchangeRateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExchangeRateService {

    private final ExchangeRateRepository exchangeRateRepository;

    public List<ExchangeRate> getAllExchangeRates(){
        return exchangeRateRepository.findAll();
    }

    public Optional<ExchangeRate> getExchangeRateByPair(String currencyPair){
        return exchangeRateRepository.findById(currencyPair);
    }

    public ExchangeRate createExchangeRate(ExchangeRate exchangeRate){
        return exchangeRateRepository.save(exchangeRate);
    }

    public ExchangeRate updateExchangeRate(String currencyPair, ExchangeRate exchangeRate){
        Optional<ExchangeRate> exchangeRateFound = exchangeRateRepository.findById(currencyPair);

        if(exchangeRateFound.isPresent()){
            ExchangeRate updatedExchangeRate = exchangeRateFound.get();
            updatedExchangeRate.setRate(exchangeRate.getRate());
            updatedExchangeRate.setLastUpdated(exchangeRate.getLastUpdated());
            return exchangeRateRepository.save(updatedExchangeRate);
        }

        return null;
    }

    public void deleteExchangeRate(String currencyPair){
        exchangeRateRepository.deleteById(currencyPair);
    }

}
