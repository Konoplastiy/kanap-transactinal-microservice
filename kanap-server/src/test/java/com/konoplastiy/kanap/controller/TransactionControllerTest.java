package com.konoplastiy.kanap.controller;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;

import com.konoplastiy.kanap.TransactionService;
import com.konoplastiy.kanap.model.TransactionDTO;
import io.micrometer.core.instrument.MeterRegistry;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TransactionControllerTest {

    private static final String TRANSACTION_ID = "1";

    @Mock
    private TransactionService serviceMock;
    @Mock
    private MeterRegistry meterRegistryMock;
    private TransactionController controller;

    @BeforeMethod
    public void setUp() {
        serviceMock = mock(TransactionService.class);
        controller = new TransactionController(serviceMock, meterRegistryMock);
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    public void shouldGetAllTransactionsTest() {
        List<TransactionDTO> mockResponse = Arrays.asList(new TransactionDTO(), new TransactionDTO());
        when(serviceMock.getAllTransactions()).thenReturn(mockResponse);

        ResponseEntity<List<TransactionDTO>> response = controller.getAllTransactions();
        verify(serviceMock, times(1)).getAllTransactions();
        assertEquals(response.getBody().size(), 2);
    }

    @Test
    public void shouldFindTransactionByIdTest() {
        Optional<TransactionDTO> mockResponse = Optional.of(new TransactionDTO());
        when(serviceMock.findTransactionById(TRANSACTION_ID)).thenReturn(mockResponse);

        ResponseEntity<Optional<TransactionDTO>> response = controller.findTransactionById(TRANSACTION_ID);
        verify(serviceMock, times(1)).findTransactionById(TRANSACTION_ID);
        assertEquals(response.getBody(), mockResponse);
    }

    @Test
    public void shouldSaveTransactionTest() {
        TransactionDTO dto = new TransactionDTO();
        when(serviceMock.saveTransaction(dto)).thenReturn(dto);

        ResponseEntity<TransactionDTO> response = controller.saveTransaction(dto);
        verify(serviceMock, times(1)).saveTransaction(dto);
        assertEquals(response.getStatusCodeValue(), 201);
    }

    @Test
    public void shouldUpdateTransactionTest() {
        TransactionDTO dto = new TransactionDTO();
        when(serviceMock.updateTransaction(dto, TRANSACTION_ID)).thenReturn(dto);

        ResponseEntity<TransactionDTO> response = controller.updateTransaction(dto, TRANSACTION_ID);
        verify(serviceMock, times(1)).updateTransaction(dto, TRANSACTION_ID);
        assertEquals(response.getBody(), dto);
    }

    @Test
    public void shouldDeleteTransactionTest() {
        TransactionDTO dto = new TransactionDTO();
        when(serviceMock.deleteTransaction(TRANSACTION_ID)).thenReturn(dto);

        ResponseEntity<TransactionDTO> response = controller.deleteTransaction(TRANSACTION_ID);
        verify(serviceMock, times(1)).deleteTransaction(TRANSACTION_ID);
        assertEquals(response.getBody(), dto);
    }
}