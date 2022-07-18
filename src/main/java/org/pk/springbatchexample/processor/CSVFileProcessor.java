package org.pk.springbatchexample.processor;

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
        LocalTime startTime = LocalTime.now();
        log.info("Starting Processing csv file {}", startTime);
        File file = new File(getFileName());
        FileInputStream inputStream = new FileInputStream(file);
        try (Scanner sc = new Scanner(inputStream, StandardCharsets.UTF_8)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                CardTransaction cardTransaction = this.cardTransactionMapper.cardTransactionMapper(line);
                repository.save(cardTransaction);
            }
        } finally {
            try {
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        LocalTime endTime = LocalTime.now();
        log.info("ending Processing csv file {}", endTime);
        log.info("Total Time Taken {}", endTime.getSecond() - startTime.getSecond());
        return true;
    }
}
