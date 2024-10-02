package com.example.bankingservice.Repository;

import com.example.bankingservice.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
