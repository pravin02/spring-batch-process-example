package org.pk.springbatchexample.processor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class FileProcessor {

    private String fileName;

    public abstract boolean processFile();
}
