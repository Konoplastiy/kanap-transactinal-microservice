package com.konoplastiy.kanap.converter;

import com.konoplastiy.kanap.common.model.TransactionFactory;
import com.konoplastiy.kanap.entity.Transaction;
import com.konoplastiy.kanap.model.TransactionDTO;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TransactionEntityToDTOConverterTest {

    private TransactionEntityToDTOConverter converter;

    @BeforeClass
    public void beforeClass() {
        converter = new TransactionEntityToDTOConverter();
    }

    @Test
    public void shouldConvertEntityToDTOPositiveTest() {
        Transaction transaction = TransactionFactory.getDefault();
        TransactionDTO transactionDTO = converter.convert(transaction);

        assertThat(transactionDTO.getTransactionType(), is(transaction.getTransactionType()));
        assertThat(transactionDTO.getAmount(), is(transaction.getAmount()));
        assertThat(transactionDTO.getCurrency(), is(transaction.getCurrency()));
        assertThat(transactionDTO.getStatus(), is(transaction.getStatus()));
        assertThat(transactionDTO.getTimestamp(), is(transaction.getTimestamp()));
    }
}