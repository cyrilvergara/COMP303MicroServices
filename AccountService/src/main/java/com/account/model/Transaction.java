package com.account.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@Document(collection = "transactions")
public class Transaction {
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
} 