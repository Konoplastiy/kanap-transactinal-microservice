package com.konoplastiy.kanap;

import com.konoplastiy.kanap.converter.TransactionDTOToEntityConverter;
import com.konoplastiy.kanap.converter.TransactionEntityToDTOConverter;
import com.konoplastiy.kanap.converter.TransactionEntityUpdater;
import com.konoplastiy.kanap.entity.Transaction;
import com.konoplastiy.kanap.exception.TransactionNotFoundException;
import com.konoplastiy.kanap.model.TransactionDTO;
import com.konoplastiy.kanap.repository.TransactionRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

public class TransactionServiceImplTest {

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private TransactionDTOToEntityConverter dtoToEntityConverter;

    @Mock
    private TransactionEntityToDTOConverter entityToDTOConverter;

    @Mock
    private TransactionEntityUpdater transactionEntityUpdater;

    @InjectMocks
    private TransactionServiceImpl transactionService;

    private static final String TRANSACTION_ID = "1";

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldFindTransactionById() {
        Transaction transaction = new Transaction();
        TransactionDTO transactionDTO = new TransactionDTO();
        when(transactionRepository.findById(TRANSACTION_ID)).thenReturn(Optional.of(transaction));
        when(entityToDTOConverter.convert(transaction)).thenReturn(transactionDTO);

        Optional<TransactionDTO> result = transactionService.findTransactionById(TRANSACTION_ID);

        assertTrue(result.isPresent());
        assertEquals(result.get(), transactionDTO);
        verify(transactionRepository).findById(TRANSACTION_ID);
        verify(entityToDTOConverter).convert(transaction);
    }

    @Test(expectedExceptions = TransactionNotFoundException.class)
    public void shouldThrowExceptionWhenTransactionNotFound() {
        when(transactionRepository.findById(TRANSACTION_ID)).thenReturn(Optional.empty());
        transactionService.findTransactionById(TRANSACTION_ID);
    }

    @Test
    public void shouldSaveTransaction() {
        TransactionDTO dto = new TransactionDTO();
        Transaction transaction = new Transaction();
        when(dtoToEntityConverter.convert(dto)).thenReturn(transaction);
        when(transactionRepository.save(transaction)).thenReturn(transaction);
        when(entityToDTOConverter.convert(transaction)).thenReturn(dto);

        TransactionDTO result = transactionService.saveTransaction(dto);

        assertNotNull(result);
        verify(transactionRepository).save(transaction);
        verify(dtoToEntityConverter).convert(dto);
        verify(entityToDTOConverter).convert(transaction);
    }

    @Test
    public void shouldDeleteTransaction() {
        Transaction transaction = new Transaction();
        TransactionDTO dto = new TransactionDTO();
        when(transactionRepository.findById(TRANSACTION_ID)).thenReturn(Optional.of(transaction));
        when(entityToDTOConverter.convert(transaction)).thenReturn(dto);

        TransactionDTO result = transactionService.deleteTransaction(TRANSACTION_ID);

        assertNotNull(result);
        verify(transactionRepository).delete(transaction);
        verify(transactionRepository).findById(TRANSACTION_ID);
        verify(entityToDTOConverter).convert(transaction);
    }

    @Test
    public void shouldGetAllTransactions() {
        List<Transaction> transactions = Arrays.asList(new Transaction(), new Transaction());
        List<TransactionDTO> transactionDTOs = Arrays.asList(new TransactionDTO(), new TransactionDTO());
        when(transactionRepository.findAll()).thenReturn(transactions);
        when(entityToDTOConverter.convert(any(Transaction.class))).thenReturn(transactionDTOs.get(0), transactionDTOs.get(1));

        List<TransactionDTO> results = transactionService.getAllTransactions();

        assertNotNull(results);
        assertEquals(results.size(), 2);
        verify(transactionRepository).findAll();
        verify(entityToDTOConverter, times(2)).convert(any(Transaction.class));
    }

    @Test
    public void shouldUpdateTransaction() {
        TransactionDTO dto = new TransactionDTO();
        Transaction existingTransaction = new Transaction();
        Transaction updatedTransaction = new Transaction();
        when(transactionRepository.findById(TRANSACTION_ID)).thenReturn(Optional.of(existingTransaction));
        when(dtoToEntityConverter.convert(dto)).thenReturn(updatedTransaction);
        when(transactionRepository.save(existingTransaction)).thenReturn(existingTransaction);
        when(entityToDTOConverter.convert(existingTransaction)).thenReturn(dto);

        TransactionDTO result = transactionService.updateTransaction(dto, TRANSACTION_ID);

        assertNotNull(result);
        verify(transactionRepository).findById(TRANSACTION_ID);
        verify(transactionEntityUpdater).updateTransactionEntity(existingTransaction, updatedTransaction);
        verify(transactionRepository).save(existingTransaction);
        verify(entityToDTOConverter).convert(existingTransaction);
    }
}