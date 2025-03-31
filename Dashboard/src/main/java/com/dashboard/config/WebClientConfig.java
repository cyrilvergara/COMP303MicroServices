package com.dashboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    
    @Bean
    public WebClient orderWebClient() {
        return WebClient.builder()
            .baseUrl("http://localhost:8081")
            .build();
    }

    @Bean
    public WebClient transactionWebClient() {
        return WebClient.builder()
            .baseUrl("http://localhost:8083")
            .build();
    }

    @Bean
    public WebClient feeWebClient() {
        return WebClient.builder()
            .baseUrl("http://localhost:8082")
            .build();
    }
} 