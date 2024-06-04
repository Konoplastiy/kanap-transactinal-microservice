package com.konoplastiy.kanap.converter;

import com.konoplastiy.kanap.entity.Transaction;
import com.konoplastiy.kanap.model.TransactionDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TransactionEntityToDTOConverter implements Converter<Transaction, TransactionDTO> {
    @Override
    public TransactionDTO convert(Transaction source) {
        return TransactionDTO.builder()
                .transactionId(source.getTransactionId())
                .sk(source.getSk())
                .transactionType(source.getTransactionType())
                .amount(source.getAmount())
                .timestamp(source.getTimestamp())
                .description(source.getDescription())
                .currency(source.getCurrency())
                .status(source.getStatus())
                .build();
    }
}
