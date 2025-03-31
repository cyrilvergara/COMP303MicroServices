package com.dashboard.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.dashboard.model.*;
import reactor.core.publisher.Mono;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

@Service
public class DashboardService {
    private final WebClient orderWebClient;
    private final WebClient transactionWebClient;
    private final WebClient feeWebClient;
    private static final Logger log = LoggerFactory.getLogger(DashboardService.class);

    public DashboardService(WebClient orderWebClient, 
                          WebClient transactionWebClient,
                          WebClient feeWebClient) {
        this.orderWebClient = orderWebClient;
        this.transactionWebClient = transactionWebClient;
        this.feeWebClient = feeWebClient;
    }

    public Mono<List<OrderDTO>> getAllOrders() {
        return orderWebClient.get()
            .uri("/api/orders")
            .retrieve()
            .bodyToFlux(OrderDTO.class)
            .collectList();
    }

    public Mono<List<TransactionDTO>> getAllTransactions() {
        return transactionWebClient.get()
            .uri("/api/transactions")
            .retrieve()
            .bodyToFlux(TransactionDTO.class)
            .collectList();
    }

    public Flux<FeeDTO> getAllFees() {
        return feeWebClient.get()
            .uri("http://localhost:8082/api/fees")
            .retrieve()
            .bodyToFlux(FeeDTO.class)
            .onErrorResume(e -> {
                log.error("Error fetching fees: ", e);
                return Flux.empty();
            });
    }

    public Mono<OrderDTO> placeOrder(OrderDTO order) {
        return orderWebClient.post()
            .uri("/api/orders")
            .bodyValue(order)
            .retrieve()
            .bodyToMono(OrderDTO.class);
    }
} 