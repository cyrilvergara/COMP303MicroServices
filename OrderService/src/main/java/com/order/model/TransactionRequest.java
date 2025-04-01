package com.order.model;

import java.time.LocalDateTime;

public class TransactionRequest {
    private String account;
    private String stockSymbol;
    private LocalDateTime transactionDate;

    public TransactionRequest(String account, String stockSymbol) {
        this.account = account;
        this.stockSymbol = stockSymbol;
        this.transactionDate = LocalDateTime.now();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
} 