package com.konoplastiy.kanap.repository;

import com.konoplastiy.kanap.entity.Transaction;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;


public interface TransactionRepository extends DynamoDBCrudRepository<Transaction, String> {
}