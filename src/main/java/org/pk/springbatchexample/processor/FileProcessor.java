package org.pk.springbatchexample.processor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.FileNotFoundException;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class FileProcessor {

    private String fileName;

    public abstract boolean processFile() throws FileNotFoundException;
}
