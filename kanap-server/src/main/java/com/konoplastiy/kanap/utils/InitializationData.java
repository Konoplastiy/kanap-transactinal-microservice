package com.konoplastiy.kanap.utils;

import com.konoplastiy.kanap.entity.Transaction;
import com.konoplastiy.kanap.model.TransactionDTO;
import com.konoplastiy.kanap.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitializationData implements CommandLineRunner {

    private final TransactionRepository transactionRepository;

    @Override
    public void run(String... args) throws Exception {
//        Transaction transaction = Transaction.builder().build();
//
//        transactionRepository.save(transaction);
    }
}
