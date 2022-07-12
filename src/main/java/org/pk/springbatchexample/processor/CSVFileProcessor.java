package org.pk.springbatchexample.processor;

import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.pk.springbatchexample.repository.CardTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Slf4j
@EqualsAndHashCode
@Primary
@Qualifier("csvFileProcessor")
@Component
public class CSVFileProcessor extends FileProcessor {

    @Autowired
    CardTransactionRepository repository;

    @Override
    public boolean processFile() {
        log.info("Processing csv file");
        return true;
    }
}
