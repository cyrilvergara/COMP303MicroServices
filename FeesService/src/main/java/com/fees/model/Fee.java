package com.fees.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "fees")
public class Fee {
    @Id
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("orderId")
    private String orderId;
    
    @JsonProperty("account")
    private String account;
    
    @JsonProperty("stockSymbol")
    private String stockSymbol;
    
    @JsonProperty("units")
    private String units;
    
    @JsonProperty("stockPrice")
    private String stockPrice;
    
    @JsonProperty("feeAmount")
    private String feeAmount;

    
    public Fee() {}


    public String getId() { return id; }
    public String getOrderId() { return orderId; }
    public String getAccount() { return account; }
    public String getStockSymbol() { return stockSymbol; }
    public String getUnits() { return units; }
    public String getStockPrice() { return stockPrice; }
    public String getFeeAmount() { return feeAmount; }

    public void setId(String id) { this.id = id; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public void setAccount(String account) { this.account = account; }
    public void setStockSymbol(String stockSymbol) { this.stockSymbol = stockSymbol; }
    public void setUnits(String units) { this.units = units; }
    public void setStockPrice(String stockPrice) { this.stockPrice = stockPrice; }
    public void setFeeAmount(String feeAmount) { this.feeAmount = feeAmount; }
} 