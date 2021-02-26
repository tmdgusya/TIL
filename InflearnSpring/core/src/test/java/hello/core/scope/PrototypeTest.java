package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeTest {

    @Test
    void prototypeBeanFind(){
        final AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        final PrototypeBean bean = ac.getBean(PrototypeBean.class);
        final PrototypeBean bean1 = ac.getBean(PrototypeBean.class);
        Assertions.assertThat(bean).isNotSameAs(bean1); // 같지않음
    }

    @Scope("prototype")
    static class PrototypeBean{
        @PostConstruct
        public void init(){
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy // => 이것또한 출력되지 않는다.
        public void destroy(){
            System.out.println("PrototypeBean.destroy");
        }
    }
}
