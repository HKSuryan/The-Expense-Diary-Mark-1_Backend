package com.mark_1.Mark_1.controllers;

import com.mark_1.Mark_1.models.Transaction;
import com.mark_1.Mark_1.service.search.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/search/{text}")
    public List<Transaction> searchByText(@PathVariable String text){
        return searchService.findByText(text);
    }
}
