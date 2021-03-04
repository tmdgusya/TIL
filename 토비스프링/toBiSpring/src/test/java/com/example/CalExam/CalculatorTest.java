package com.example.CalExam;

import com.example.CalExam.Calculator;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    @Test
    void sumOfNumbers() throws IOException {
        Calculator calculator = new Calculator();
        int sum = calculator.calcSum("/Users/jeongseunghyeon/Desktop/study/TIL/토비스프링/toBiSpring/src/main/java/com/example/toBiSpring/numbers.txt");
        assertThat(sum).isEqualTo(10);
    }

}
