package org.example;

import java.io.IOException;

public class Masulsa {

    public static void main(String[] args) throws IOException {
//        new ByteBuddy().redefine(Moja.class).method(named("pullOut")).intercept(FixedValue.value("Rabbit"))
//        .make().saveIn(new File("/Users/jeongseunghyeon/Desktop/study/TIL/roach/target/classes/"));

        /*원래 "" 인데 바이트 코드를 조작해서 토끼가 나온다...*/
        System.out.println(new Moja().pullOut());
    }

}
