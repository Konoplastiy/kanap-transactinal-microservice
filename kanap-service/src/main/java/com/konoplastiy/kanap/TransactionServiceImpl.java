package com.konoplastiy.kanap;

import com.konoplastiy.kanap.converter.TransactionDTOToEntityConverter;
import com.konoplastiy.kanap.converter.TransactionEntityToDTOConverter;
import com.konoplastiy.kanap.converter.TransactionEntityUpdater;
import com.konoplastiy.kanap.entity.Transaction;
import com.konoplastiy.kanap.exception.TransactionNotFoundException;
import com.konoplastiy.kanap.model.TransactionDTO;
import com.konoplastiy.kanap.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionDTOToEntityConverter dtoToEntityConverter;
    private final TransactionEntityToDTOConverter entityToDTOConverter;
    private final TransactionEntityUpdater transactionEntityUpdater;


    @Override
    public Optional<TransactionDTO> findTransactionById(String transactionId) {
        return Optional.ofNullable(transactionRepository.findById(transactionId)
                .map(entityToDTOConverter::convert)
                .orElseThrow(() -> new TransactionNotFoundException(
                                String.format("Transactional with id %s not found", transactionId)
                        )
                )
        );
    }

    @Override
    public TransactionDTO saveTransaction(TransactionDTO transactionalDto) {
        Transaction transaction = dtoToEntityConverter.convert(transactionalDto);
        transaction = transactionRepository.save(transaction);
        return entityToDTOConverter.convert(transaction);
    }

    @Override
    public TransactionDTO deleteTransaction(String transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new TransactionNotFoundException(
                                String.format("Transaction with id %s not found", transactionId)
                        )
                );

        TransactionDTO transactionDTO = entityToDTOConverter.convert(transaction);
        transactionRepository.delete(transaction);
        return transactionDTO;
    }

    @Override
    public List<TransactionDTO> getAllTransactions() {
        Iterable<Transaction> transactions = transactionRepository.findAll();
        return StreamSupport.stream(transactions.spliterator(), false)
                .map(entityToDTOConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDTO updateTransaction(TransactionDTO transactionDto) {
        Transaction existingTransaction = transactionRepository.findById(transactionDto.getTransactionId())
                .orElseThrow(() -> new TransactionNotFoundException(
                                String.format("Transaction with id %s not found", transactionDto.getTransactionId())
                        )
                );
        Transaction updatedTransaction = dtoToEntityConverter.convert(transactionDto);
        transactionEntityUpdater.updateTransactionEntity(existingTransaction, updatedTransaction);
        existingTransaction = transactionRepository.save(existingTransaction);
        return entityToDTOConverter.convert(existingTransaction);
    }
}
