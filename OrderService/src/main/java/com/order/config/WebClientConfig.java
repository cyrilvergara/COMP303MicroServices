package com.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    
    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    public WebClient transactionWebClient(WebClient.Builder builder) {
        return builder.baseUrl("http://localhost:8083").build();
    }

    @Bean
    public WebClient feeWebClient(WebClient.Builder builder) {
        return builder.baseUrl("http://localhost:8082").build();
    }
} 