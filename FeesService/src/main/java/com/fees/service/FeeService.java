package com.fees.service;

import org.springframework.stereotype.Service;
import com.fees.model.Fee;
import com.fees.repository.FeeRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FeeService {
    
    private final FeeRepository feeRepository;

    public FeeService(FeeRepository feeRepository) {
        this.feeRepository = feeRepository;
    }

    public Mono<Fee> createFee(Fee fee) {
        try {
            
            double units = Double.parseDouble(fee.getUnits());
            double price = Double.parseDouble(fee.getStockPrice());
            double feeAmount = units * price * 0.01;
            
            
            fee.setFeeAmount(String.format("%.2f", feeAmount));
            
            System.out.println("Calculated fee amount: " + fee.getFeeAmount()); 
            return feeRepository.save(fee);
        } catch (Exception e) {
            System.out.println("Error calculating fee: " + e.getMessage()); 
            return Mono.error(e);
        }
    }

    public Flux<Fee> getAllFees() {
        return feeRepository.findAll();
    }
} 