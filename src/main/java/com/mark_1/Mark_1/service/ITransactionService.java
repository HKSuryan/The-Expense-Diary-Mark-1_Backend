package com.mark_1.Mark_1.service;


import com.mark_1.Mark_1.models.Transaction;
import com.mark_1.Mark_1.requests.AddTransactionRequest;

import java.util.List;

public interface ITransactionService {
    Transaction addTransaction(AddTransactionRequest request);

    List<Transaction> getAllTransactions();
}
