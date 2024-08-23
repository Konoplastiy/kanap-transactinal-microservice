package com.konoplastiy.kanap.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.konoplastiy.kanap.TransactionService;
import com.konoplastiy.kanap.model.TransactionDTO;
import io.micrometer.core.instrument.MeterRegistry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;


@ExtendWith(MockitoExtension.class)
public class TransactionControllerTest {

  private static final String TRANSACTION_ID = "1";

  @Mock
  private TransactionService serviceMock;
  @Mock
  private MeterRegistry meterRegistryMock;

  @InjectMocks
  private TransactionController controller;

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