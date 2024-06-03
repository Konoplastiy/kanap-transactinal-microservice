package com.konoplastiy.kanap;

import com.konoplastiy.kanap.model.TransactionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    @Override
    public List<TransactionDTO> getAllProducts() {
        return null;
    }

    @Override
    public TransactionDTO getProductById(String id) {
        return null;
    }

    @Override
    public TransactionDTO createNewProduct(TransactionDTO dto) {
        return null;
    }

    @Override
    public TransactionDTO updateProduct(String id, TransactionDTO dto) {
        return null;
    }

    @Override
    public void deleteProduct(String id) {

    }
}
