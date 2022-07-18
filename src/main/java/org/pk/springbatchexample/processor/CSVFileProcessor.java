package org.pk.springbatchexample.processor;

import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.pk.springbatchexample.CardTransactionMapper;
import org.pk.springbatchexample.entity.CardTransaction;
import org.pk.springbatchexample.repository.CardTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.util.Scanner;

@EqualsAndHashCode(callSuper = false)
@Slf4j
@Primary
@Qualifier("csvFileProcessor")
@Component
public class CSVFileProcessor extends FileProcessor {

    @Autowired
    CardTransactionRepository repository;

    @Autowired
    CardTransactionMapper cardTransactionMapper;

    @Override
    public boolean processFile() throws FileNotFoundException {
        var startTime = LocalTime.now();
        log.info("Starting Processing csv file {}", startTime);
        CardTransaction cardTransaction = null;
        var file = new File(getFileName());
        var inputStream = new FileInputStream(file);
        try (var sc = new Scanner(inputStream, StandardCharsets.UTF_8)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                cardTransaction = this.cardTransactionMapper.cardTransactionMapper(line);
                repository.save(cardTransaction);
            }
        } finally {
            try {
                inputStream.close();
            } catch (Exception e) {
                log.error("error while closing input stream", e);
            }
        }
        var endTime = LocalTime.now();
        log.info("ending Processing csv file {}", endTime);
        log.info("Total Time Taken {}", endTime.getSecond() - startTime.getSecond());
        return true;
    }
}
