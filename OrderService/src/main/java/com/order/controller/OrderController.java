package com.order.controller;

import org.springframework.web.bind.annotation.*;
import com.order.model.Order;
import com.order.service.OrderService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Mono<Order> createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping
    public Flux<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Mono<Order> getOrderById(@PathVariable String id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/symbol/{stockSymbol}")
    public Flux<Order> getOrdersByStockSymbol(@PathVariable String stockSymbol) {
        return orderService.getOrdersByStockSymbol(stockSymbol);
    }

    @GetMapping("/account/{account}")
    public Flux<Order> getOrdersByAccount(@PathVariable String account) {
        return orderService.getOrdersByAccount(account);
    }
} 