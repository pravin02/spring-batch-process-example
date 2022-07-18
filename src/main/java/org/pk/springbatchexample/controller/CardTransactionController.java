package org.pk.springbatchexample.controller;

import org.pk.springbatchexample.entity.CardTransaction;
import org.pk.springbatchexample.processor.FileProcessor;
import org.pk.springbatchexample.repository.CardTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/card-transactions")
public class CardTransactionController {

    @Autowired
    private CardTransactionRepository repository;

    @Autowired
    private FileProcessor fileProcessor;

    @GetMapping("/load")
    public String processCardTransactions() throws FileNotFoundException {
        fileProcessor.setFileName(new ClassPathResource("electronic-card-transactions-may-2022-csv-tables.csv").getPath());
        boolean response = fileProcessor.processFile();
        return response ? "OK" : "Something went wrong";
    }

    @GetMapping
    public List<CardTransaction> cardTransactions() {
        return repository.findAll();
    }
}
