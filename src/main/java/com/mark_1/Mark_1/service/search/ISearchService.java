package com.mark_1.Mark_1.service.search;

import com.mark_1.Mark_1.models.Transaction;

import java.util.List;

public interface ISearchService {
    List<Transaction> findByText(String text);
}
