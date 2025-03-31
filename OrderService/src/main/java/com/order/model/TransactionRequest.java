package com.order.model;

public class TransactionRequest {
    private String account;
    private String stockSymbol;
    private String units;
    private String stockPrice;

    public TransactionRequest(String account, String stockSymbol, String units, 
                            String stockPrice) {
        this.account = account;
        this.stockSymbol = stockSymbol;
        this.units = units;
        this.stockPrice = stockPrice;
    }

    public String getAccount() { return account; }
    public String getStockSymbol() { return stockSymbol; }
    public String getUnits() { return units; }
    public String getStockPrice() { return stockPrice; }

    public void setAccount(String account) { this.account = account; }
    public void setStockSymbol(String stockSymbol) { this.stockSymbol = stockSymbol; }
    public void setUnits(String units) { this.units = units; }
    public void setStockPrice(String stockPrice) { this.stockPrice = stockPrice; }
} 