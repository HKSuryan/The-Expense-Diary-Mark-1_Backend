package com.mark_1.Mark_1.controllers;

import com.mark_1.Mark_1.models.Transaction;
import com.mark_1.Mark_1.requests.AddTransactionRequest;
import com.mark_1.Mark_1.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping("/add")
    public Transaction addTransaction(@RequestBody AddTransactionRequest request){
        return transactionService.addTransaction(request);
    }

    @GetMapping("/all")
    public List<Transaction> getAllTransactions(){
        return transactionService.getAllTransactions();
    }
}
