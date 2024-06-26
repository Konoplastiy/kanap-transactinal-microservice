package com.konoplastiy.kanap.converter;

import com.konoplastiy.kanap.entity.Transaction;
import com.konoplastiy.kanap.model.TransactionDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TransactionDTOToEntityConverter implements Converter<TransactionDTO, Transaction> {
    @Override
    public Transaction convert(TransactionDTO source) {
        return Transaction.builder()
                .transactionType(source.getTransactionType())
                .currency(source.getCurrency())
                .status(source.getStatus())
                .build();
    }
}
