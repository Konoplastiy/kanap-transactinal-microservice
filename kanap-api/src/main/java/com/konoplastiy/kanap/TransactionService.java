package com.konoplastiy.kanap;

import com.konoplastiy.kanap.model.TransactionDTO;

import java.util.List;
import java.util.Optional;

public interface TransactionService {

    Optional<TransactionDTO> findById(String transactionId);
    TransactionDTO save(TransactionDTO transactionalDto);
    void delete(String transactionId);
    List<TransactionDTO> getAllTransactions();
    TransactionDTO update(TransactionDTO transactionalDto);
}
