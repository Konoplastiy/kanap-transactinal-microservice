package com.konoplastiy.kanap;

import com.konoplastiy.kanap.model.TransactionDTO;

import java.util.List;
import java.util.Optional;

public interface TransactionService {

    Optional<TransactionDTO> findTransactionById(String transactionId);
    TransactionDTO saveTransaction(TransactionDTO transactionalDto);
    TransactionDTO deleteTransaction(String transactionId);
    List<TransactionDTO> getAllTransactions();
    TransactionDTO updateTransaction(TransactionDTO transactionalDto);
}
