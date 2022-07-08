package org.pk.springbatchexample;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchProcessExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchProcessExampleApplication.class, args);
	}

}
