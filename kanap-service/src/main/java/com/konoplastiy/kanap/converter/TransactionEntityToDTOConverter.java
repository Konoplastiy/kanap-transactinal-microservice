package com.konoplastiy.kanap.converter;

import com.konoplastiy.kanap.entity.Transaction;
import com.konoplastiy.kanap.model.TransactionDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TransactionEntityToDTOConverter implements Converter<Transaction, TransactionDTO> {

    @Override
    public TransactionDTO convert(Transaction source) {
        return null;
    }
}
