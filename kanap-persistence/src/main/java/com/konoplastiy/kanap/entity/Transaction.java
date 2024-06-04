package com.konoplastiy.kanap.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "TransactionInfo")
public class Transaction  {

    @DynamoDBHashKey(attributeName = "transaction_id")
    @DynamoDBAttribute(attributeName = "transaction_id")
    private String transactionId;

    @DynamoDBRangeKey(attributeName = "sk")
    @DynamoDBAttribute(attributeName = "sk")
    private String sk;

    @DynamoDBAttribute(attributeName = "transaction_type")
    private String transactionType;

    @DynamoDBAttribute(attributeName = "amount")
    private BigDecimal amount;

    @DynamoDBAttribute(attributeName = "timestamp")
    private Instant timestamp;

    @DynamoDBAttribute(attributeName = "description")
    private String description;

    @DynamoDBAttribute(attributeName = "currency")
    private String currency;

    @DynamoDBAttribute(attributeName = "status")
    private String status;
}
