package com.example.bankingservice.Service;

import com.example.bankingservice.Model.Transaction;
import com.example.bankingservice.Repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(int id) {
        return transactionRepository.findById(id);
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(int id, Transaction transaction) {
        Optional<Transaction> transactionFound = transactionRepository.findById(id);

        if (transactionFound.isPresent()) {
            Transaction updatedTransaction = transactionFound.get();
            updatedTransaction.setAccount(transaction.getAccount());
            updatedTransaction.setDate(transaction.getDate());
            updatedTransaction.setAmount(transaction.getAmount());
            updatedTransaction.setType(transaction.getType());
            updatedTransaction.setDescription(transaction.getDescription());
            updatedTransaction.setCategory(transaction.getCategory());
            updatedTransaction.setMerchantName(transaction.getMerchantName());
            updatedTransaction.setMerchantLocation(transaction.getMerchantLocation());
            return transactionRepository.save(updatedTransaction);
        }

        return null;
    }

    public void deleteTransaction(int id) {
        transactionRepository.deleteById(id);
    }
}
