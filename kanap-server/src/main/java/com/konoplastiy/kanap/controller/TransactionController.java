package com.konoplastiy.kanap.controller;


import com.konoplastiy.kanap.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.konoplastiy.kanap.ApplicationConstants.URLConstants.BASE_URL_TRANSACTIONS;

@RestController
@RequestMapping(BASE_URL_TRANSACTIONS)
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;


}
