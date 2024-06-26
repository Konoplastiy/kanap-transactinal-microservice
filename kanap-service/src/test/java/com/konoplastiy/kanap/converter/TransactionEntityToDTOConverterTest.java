package com.konoplastiy.kanap.converter;

import com.konoplastiy.kanap.entity.Transaction;
import com.konoplastiy.kanap.model.TransactionDTO;
import org.jeasy.random.EasyRandom;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TransactionEntityToDTOConverterTest {

    private TransactionEntityToDTOConverter converter;

    @BeforeMethod
    public void setUp() {
        converter = new TransactionEntityToDTOConverter();
    }

    @Test
    public void testConvert() {
        Transaction expected = new EasyRandom().nextObject(Transaction.class);
        TransactionDTO actual = converter.convert(expected);

        assertNotNull(actual);
        assertEquals(actual.getTransactionType(), expected.getTransactionType());
        assertEquals(actual.getAmount(), expected.getAmount());
        assertEquals(actual.getTimestamp(), expected.getTimestamp());
        assertEquals(actual.getCurrency(), expected.getCurrency());
        assertEquals(actual.getStatus(), expected.getStatus());
    }
}