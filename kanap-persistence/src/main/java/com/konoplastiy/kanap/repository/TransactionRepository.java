package com.konoplastiy.kanap.repository;

import com.konoplastiy.kanap.entity.Transaction;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface TransactionRepository extends CrudRepository<Transaction, String> {
    Optional<Transaction> findById(String id);
}