package com.fees.controller;

import org.springframework.web.bind.annotation.*;
import com.fees.model.Fee;
import com.fees.service.FeeService;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/fees")
public class FeeController {

    private final FeeService feeService;

    public FeeController(FeeService feeService) {
        this.feeService = feeService;
    }

    @PostMapping
    public Mono<Fee> createFee(@RequestBody Fee fee) {
        return feeService.createFee(fee);
    }

    @GetMapping
    public Flux<Fee> getAllFees() {
        return feeService.getAllFees();
    }
} 