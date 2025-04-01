package com.order.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "orders")
public class Order {
    @Id
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("account")
    private String account;
    
    @JsonProperty("stockSymbol")
    private String stockSymbol;
    
    @JsonProperty("units")
    private String units;
    
    @JsonProperty("stockPrice")
    private String stockPrice;

    public String getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public String getUnits() {
        return units;
    }

    public String getStockPrice() {
        return stockPrice;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public void setStockPrice(String stockPrice) {
        this.stockPrice = stockPrice;
    }

} 