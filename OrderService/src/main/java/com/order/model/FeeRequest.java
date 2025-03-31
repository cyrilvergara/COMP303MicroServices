package com.order.model;

public class FeeRequest {
    private String orderId;
    private String account;
    private String stockSymbol;
    private String units;
    private String stockPrice;

    public FeeRequest(String orderId, String account, String stockSymbol, 
                     String units, String stockPrice) {
        this.orderId = orderId;
        this.account = account;
        this.stockSymbol = stockSymbol;
        this.units = units;
        this.stockPrice = stockPrice;
    }

    public String getOrderId() { return orderId; }
    public String getAccount() { return account; }
    public String getStockSymbol() { return stockSymbol; }
    public String getUnits() { return units; }
    public String getStockPrice() { return stockPrice; }

    public void setOrderId(String orderId) { this.orderId = orderId; }
    public void setAccount(String account) { this.account = account; }
    public void setStockSymbol(String stockSymbol) { this.stockSymbol = stockSymbol; }
    public void setUnits(String units) { this.units = units; }
    public void setStockPrice(String stockPrice) { this.stockPrice = stockPrice; }
} 