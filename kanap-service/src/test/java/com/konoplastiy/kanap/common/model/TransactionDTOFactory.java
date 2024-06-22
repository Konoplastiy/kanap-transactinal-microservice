package com.konoplastiy.kanap.common.model;

import com.konoplastiy.kanap.model.TransactionDTO;

import java.math.BigDecimal;
import java.time.Instant;

public class TransactionDTOFactory {
    public static TransactionDTO getDefault() {
        return TransactionDTO.builder()
                .transactionType("Deposit")
                .amount(BigDecimal.TEN)
                .timestamp(Instant.now())
                .currency("UA")
                .status("Completed")
                .build();
    }
}
