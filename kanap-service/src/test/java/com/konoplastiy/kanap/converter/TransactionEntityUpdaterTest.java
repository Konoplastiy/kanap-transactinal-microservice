package com.konoplastiy.kanap.converter;

import com.konoplastiy.kanap.entity.Transaction;
import org.jeasy.random.EasyRandom;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TransactionEntityUpdaterTest {

    private TransactionEntityUpdater updater;

    @BeforeMethod
    public void setUp() {
        updater = new TransactionEntityUpdater();
    }

    @Test
    public void testUpdateTransactionEntity() {
        Transaction existingTransaction = new EasyRandom().nextObject(Transaction.class);
        Transaction updatedTransaction  = new EasyRandom().nextObject(Transaction.class);

        updater.updateTransactionEntity(existingTransaction, updatedTransaction);

        assertNotNull(existingTransaction);
        assertEquals(existingTransaction.getTransactionType(), updatedTransaction.getTransactionType());
        assertEquals(existingTransaction.getCurrency(), updatedTransaction.getCurrency());
        assertEquals(existingTransaction.getStatus(), updatedTransaction.getStatus());
    }
}