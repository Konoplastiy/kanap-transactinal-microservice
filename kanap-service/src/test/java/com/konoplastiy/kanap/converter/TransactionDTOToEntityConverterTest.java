package com.konoplastiy.kanap.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.konoplastiy.kanap.entity.Transaction;
import com.konoplastiy.kanap.model.TransactionDTO;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TransactionDTOToEntityConverterTest {

    private TransactionDTOToEntityConverter converter;

    @BeforeEach
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