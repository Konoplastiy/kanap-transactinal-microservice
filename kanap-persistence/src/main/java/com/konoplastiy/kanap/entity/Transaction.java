package com.konoplastiy.kanap.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "TransactionInfo")
public class Transaction {

    private String transactionId;

    private String tenant;

    private Long amount;
}
