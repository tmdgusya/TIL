package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void stateFullServieSingleTon(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = annotationConfigApplicationContext.getBean(StatefulService.class);
        StatefulService statefulService2 = annotationConfigApplicationContext.getBean(StatefulService.class);
        Assertions.assertThat(statefulService1).isEqualTo(statefulService2); // SingleTon

        //Thread A : 사용자 A
        statefulService1.order("userA ", 10000);
        //Thread B : 사용자 B
        statefulService2.order("userB", 20000);

        int price = statefulService1.getPrice();
        Assertions.assertThat(10000).isEqualTo(price); // 상태를 가져서 간섭을 받게됨
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}