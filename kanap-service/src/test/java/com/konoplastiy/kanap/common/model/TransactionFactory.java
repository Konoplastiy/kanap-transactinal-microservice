package com.konoplastiy.kanap.common.model;

import com.konoplastiy.kanap.entity.Transaction;

import java.math.BigDecimal;
import java.time.Instant;

public class TransactionFactory {
    public static Transaction getDefault() {
        return Transaction.builder()
                .transactionType("Deposit")
                .amount(BigDecimal.TEN)
                .timestamp(Instant.now())
                .currency("UA")
                .status("Completed")
                .build();
    }
}
