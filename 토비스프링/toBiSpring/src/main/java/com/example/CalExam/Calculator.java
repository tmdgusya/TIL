package com.example.CalExam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {

    public Integer calcMutiply(String filepath) throws IOException {

        BufferedReaderCallback multiplyCallback = new BufferedReaderCallback() {
            @Override
            public Integer doSomethingWithReader(BufferedReader bufferedReader) throws IOException {
                Integer multiply = 1;
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    multiply *= Integer.parseInt(line);
                }
                return multiply;
            }
        };
        return fileReadTemplate(filepath, multiplyCallback);
    }

    public Integer calcSum(String filepath) throws IOException {

        BufferedReaderCallback sumCallback = new BufferedReaderCallback() {
            @Override
            public Integer doSomethingWithReader(BufferedReader bufferedReader) throws IOException {
                Integer sum = 0;
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    sum += Integer.parseInt(line);
                }
                return sum;
            }
        };
        return fileReadTemplate(filepath, sumCallback);
    }

    public Integer fileReadTemplate(String filepath, BufferedReaderCallback callback) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            int ret = callback.doSomethingWithReader(br);
            return ret;
        } catch (IOException e) {
            throw e;
        }
    }

}
