package com.mark_1.Mark_1.service;

import com.google.gson.Gson;
import com.mark_1.Mark_1.models.Transaction;
import com.mark_1.Mark_1.repository.TransactionRepository;
import com.mark_1.Mark_1.requests.AddTransactionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TransactionService implements ITransactionService{
    private final TransactionRepository transactionRepository;
    private final ChatResponseService chatResponseService;
    @Override
    public Transaction addTransaction(AddTransactionRequest request) {
        Transaction transaction  = null;
//
//        transactionRepository.save(transaction);

        String prompt = request.getName()+request.getMessage()+"From the above mentioned information return an object containing properties, in the direction instead of debited and credited use in or out" +
                "String amount:" +
                "String paymentMode:" +
                "String date:" +
                "String direction:" +
                "String name:";

        String object = chatResponseService.getOpenAiResponse(prompt);

        Gson gson = new Gson();
        transaction = gson.fromJson(object,Transaction.class);

        transactionRepository.save(transaction);

        return transaction;






//        return request.getMessage()+request.getName();

    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();

    }
}
