package com.order.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.order.model.Order;
import com.order.model.TransactionRequest;
import com.order.model.FeeRequest;
import com.order.repository.OrderRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {
    
    private final OrderRepository orderRepository;
    private final WebClient feeWebClient;
    private final WebClient transactionWebClient;

    public OrderService(OrderRepository orderRepository, 
                       WebClient feeWebClient,
                       WebClient transactionWebClient) {
        this.orderRepository = orderRepository;
        this.feeWebClient = feeWebClient;
        this.transactionWebClient = transactionWebClient;
    }

    public Mono<Order> createOrder(Order order) {
        return orderRepository.save(order)
            .flatMap(savedOrder -> {
                return createFee(savedOrder)
                    .then(createTransaction(savedOrder))
                    .thenReturn(savedOrder);
            });
    }

    private Mono<Void> createTransaction(Order order) {
        var transaction = new TransactionRequest(
                order.getAccount(),
                order.getStockSymbol()
        );

        return transactionWebClient.post()
                .uri("/api/transactions")
                .bodyValue(transaction)
                .retrieve()
                .bodyToMono(Void.class);
    }

    private Mono<Void> createFee(Order order) {
        var feeRequest = new FeeRequest(
            order.getId(),
            order.getAccount(),
            order.getStockSymbol(),
            order.getUnits(),
            order.getStockPrice()
        );

        return feeWebClient.post()
            .uri("/api/fees")
            .bodyValue(feeRequest)
            .retrieve()
            .bodyToMono(Object.class)
            .then();
    }

    public Flux<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Mono<Order> getOrderById(String id) {
        return orderRepository.findById(id);
    }

    public Flux<Order> getOrdersByStockSymbol(String stockSymbol) {
        return orderRepository.findByStockSymbol(stockSymbol);
    }

    public Flux<Order> getOrdersByAccount(String account) {
        return orderRepository.findByAccount(account);
    }
} 