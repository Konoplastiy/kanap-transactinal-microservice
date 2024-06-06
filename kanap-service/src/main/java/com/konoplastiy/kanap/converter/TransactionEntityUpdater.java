package com.konoplastiy.kanap.converter;

import com.konoplastiy.kanap.entity.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionEntityUpdater {
    public void updateTransactionEntity(Transaction existingTransaction, Transaction updatedTransaction) {
        existingTransaction.setTransactionType(updatedTransaction.getTransactionType());
        existingTransaction.setAmount(updatedTransaction.getAmount());
        existingTransaction.setTimestamp(updatedTransaction.getTimestamp());
        existingTransaction.setCurrency(updatedTransaction.getCurrency());
        existingTransaction.setStatus(updatedTransaction.getStatus());
    }
}
