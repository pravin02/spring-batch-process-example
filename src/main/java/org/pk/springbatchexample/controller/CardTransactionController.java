package org.pk.springbatchexample.controller;

import org.pk.springbatchexample.entity.CardTransaction;
import org.pk.springbatchexample.repository.CardTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/card-transactions")
public class CardTransactionController {

    @Autowired
    private CardTransactionRepository repository;

    @GetMapping
    public List<CardTransaction> cardTransactions() {
        return repository.findAll();
    }
}
