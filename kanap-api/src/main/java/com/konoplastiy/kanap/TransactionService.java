package com.konoplastiy.kanap;

import com.konoplastiy.kanap.model.TransactionDTO;

import java.util.List;

public interface TransactionService {

    List<TransactionDTO> getAllProducts();

    TransactionDTO getProductById(String id);

    TransactionDTO createNewProduct(TransactionDTO dto);

    TransactionDTO updateProduct(String id, TransactionDTO dto);

    void deleteProduct(String id);
}
