package com.example.bankingservice.Service;

import com.example.bankingservice.Model.Account;
import com.example.bankingservice.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(int id) {
        return accountRepository.findById(id);
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account updateAccount(int id, Account account) {
        Optional<Account> accountFound = accountRepository.findById(id);

        if (accountFound.isPresent()) {
            Account updatedAccount = accountFound.get();
            updatedAccount.setAccountType(account.getAccountType());
            updatedAccount.setBalance(account.getBalance());
            updatedAccount.setCurrency(account.getCurrency());
            updatedAccount.setCreatedDate(account.getCreatedDate());
            updatedAccount.setLastTransactionDate(account.getLastTransactionDate());
            updatedAccount.setStatus(account.getStatus());
            return accountRepository.save(updatedAccount);
        }

        return null;
    }

    public void deleteAccount(int id) {
        accountRepository.deleteById(id);
    }
}
