package com.konoplastiy.kanap.converter;

import com.konoplastiy.kanap.common.model.TransactionDTOFactory;
import com.konoplastiy.kanap.entity.Transaction;
import com.konoplastiy.kanap.model.TransactionDTO;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TransactionDTOToEntityConverterTest {

    private TransactionDTOToEntityConverter converter;

    @BeforeClass
    public void setup() {
        converter = new TransactionDTOToEntityConverter();
    }

    @Test
    public void shouldConvertDTOToEntityPositiveTest() {
        TransactionDTO transactionDTO = TransactionDTOFactory.getDefault();
        Transaction transaction = converter.convert(transactionDTO);

        assertThat(transaction.getTransactionType(), is(transactionDTO.getTransactionType()));
        assertThat(transaction.getAmount(), is(transactionDTO.getAmount()));
        assertThat(transaction.getCurrency(), is(transactionDTO.getCurrency()));
        assertThat(transaction.getStatus(), is(transactionDTO.getStatus()));
        assertThat(transaction.getTimestamp(), is(transactionDTO.getTimestamp()));
    }
}