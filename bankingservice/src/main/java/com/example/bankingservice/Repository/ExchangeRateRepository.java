package com.example.bankingservice.Repository;

import com.example.bankingservice.Model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Integer> {
}
