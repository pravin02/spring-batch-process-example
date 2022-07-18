package org.pk.springbatchexample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBatchProcessExampleApplicationTests {

    String input = "test";

    @Test
    void contextLoads() {
        Assertions.assertEquals("test", input);
    }

}
