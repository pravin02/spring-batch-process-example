package org.pk.springbatchexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {


    @GetMapping
    public String index() {
        return "Welcome to spring batch processing example";
    }
}