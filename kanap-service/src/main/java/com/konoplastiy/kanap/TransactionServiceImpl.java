package com.konoplastiy.kanap;

import com.konoplastiy.kanap.converter.TransactionDTOToEntityConverter;
import com.konoplastiy.kanap.converter.TransactionEntityToDTOConverter;
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


    @Override
    public Optional<TransactionDTO> findById(String transactionId) {
        return Optional.ofNullable(transactionRepository.findById(transactionId)
                .map(entityToDTOConverter::convert)
                .orElseThrow(() -> new TransactionNotFoundException(
                                "Transactional with id %d not found" + transactionId
                        )
                )
        );
    }

    @Override
    public TransactionDTO save(TransactionDTO transactionalDto) {
        Transaction transaction = dtoToEntityConverter.convert(transactionalDto);
        transaction = transactionRepository.save(transaction);
        return entityToDTOConverter.convert(transaction);
    }

    @Override
    public void delete(String transactionId) {
        transactionRepository.deleteById(transactionId);
    }

    @Override
    public List<TransactionDTO> getAllTransactions() {
        Iterable<Transaction> transactions = transactionRepository.findAll();
        return StreamSupport.stream(transactions.spliterator(), false)
                .map(entityToDTOConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public TransactionDTO update(TransactionDTO transactionalDto) {
        return null;
    }
}
