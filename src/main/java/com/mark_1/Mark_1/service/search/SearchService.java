package com.mark_1.Mark_1.service.search;

import com.google.gson.Gson;
import com.mark_1.Mark_1.models.Transaction;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SearchService implements ISearchService{
    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter mongoConverter;
    @Override
    public List<Transaction> findByText(String text) {
        List<Transaction> transactions = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("mark_1");
        MongoCollection<Document> collection = database.getCollection("transactions");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("index", "Mark_Search_1")
                        .append("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("name", "date", "direction", "amount"))))));



        result.forEach(doc->transactions.add(mongoConverter.read(Transaction.class,doc)));

        return transactions;
    }
}
