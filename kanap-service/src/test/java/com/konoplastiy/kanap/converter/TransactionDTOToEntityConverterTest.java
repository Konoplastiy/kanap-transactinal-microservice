package com.konoplastiy.kanap.converter;

import com.konoplastiy.kanap.entity.Transaction;
import com.konoplastiy.kanap.model.TransactionDTO;
import org.jeasy.random.EasyRandom;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class TransactionDTOToEntityConverterTest {

    private TransactionDTOToEntityConverter converter;

    @BeforeMethod
    public void beforeMethod() {
        converter = new TransactionDTOToEntityConverter();
    }

    @Test
    public void testConverter() {
        TransactionDTO expected = new EasyRandom().nextObject(TransactionDTO.class);
        Transaction actual = converter.convert(expected);

        assertNotNull(actual);
        assertEquals(actual.getTransactionType(), expected.getTransactionType());
        assertEquals(actual.getCurrency(), expected.getCurrency());
        assertEquals(actual.getStatus(), expected.getStatus());
    }
}