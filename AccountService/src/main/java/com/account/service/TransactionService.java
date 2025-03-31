package com.account.service;

import org.springframework.stereotype.Service;
import com.account.model.Transaction;
import com.account.repository.TransactionRepository;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@Service
public class TransactionService {
    
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Mono<Transaction> createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Flux<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

} 