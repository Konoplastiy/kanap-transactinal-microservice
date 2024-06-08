package com.konoplastiy.kanap.controller;


import com.konoplastiy.kanap.TransactionService;
import com.konoplastiy.kanap.model.TransactionDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.konoplastiy.kanap.ApplicationConstants.URLConstants.BASE_URL_TRANSACTIONS;

@Slf4j
@Validated
@RestController
@RequestMapping(BASE_URL_TRANSACTIONS)
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<TransactionDTO>> getAllTransactions() {
        List<TransactionDTO> response = transactionService.getAllTransactions();
        log.info("Fetching all transactions");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<Optional<TransactionDTO>> findTransactionById(
            @PathVariable("transactionId") String transactionId) {
        Optional<TransactionDTO> response = transactionService.findTransactionById(transactionId);
        log.info("Find the transaction by {} id", transactionId);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<TransactionDTO> saveTransaction(@Valid @RequestBody TransactionDTO transactionDTO) {
        TransactionDTO response = transactionService.saveTransaction(transactionDTO);
        log.info("Save a new transaction");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{transactionId}")
    public ResponseEntity<TransactionDTO> updateTransaction(
            @RequestBody TransactionDTO transactionDto,
            @PathVariable("transactionId") String transactionId
    ) {
        TransactionDTO response = transactionService.updateTransaction(transactionDto, transactionId);
        log.info("Successfully updated transaction with ID: {}", transactionId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{transactionId}")
    public ResponseEntity<TransactionDTO> deleteTransaction(@PathVariable("transactionId") String transactionId) {
        TransactionDTO response = transactionService.deleteTransaction(transactionId);
        log.info("Deleting transaction with ID: {}", transactionId);
        return ResponseEntity.ok(response);
    }
}
