package com.fees.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.fees.model.Fee;

@Repository
public interface FeeRepository extends ReactiveMongoRepository<Fee, String> {
} 