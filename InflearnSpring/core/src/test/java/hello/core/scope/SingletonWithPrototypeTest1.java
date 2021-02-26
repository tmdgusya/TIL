package hello.core.scope;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonWithPrototypeTest1 {

    @Test
    void prototypeFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean prototypeBean = ac.getBean(PrototypeBean.class);
        prototypeBean.addCount();
        Assertions.assertThat(prototypeBean.getCount()).isEqualTo(1);

        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        prototypeBean1.addCount();
        Assertions.assertThat(prototypeBean1.getCount()).isEqualTo(1);
    }

    @Test
    void singletonClientUserPrototype(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(CilientBean.class, PrototypeBean.class);
        CilientBean bean1 = ac.getBean(CilientBean.class);
        int logic1 = bean1.logic();
        CilientBean bean2 = ac.getBean(CilientBean.class);
        int logic2 = bean2.logic();
        // 간단히 얘기하면 bean1 이랑 bean2 가 같은 객체이기때문에그럼. prototype Class 는 이미 주입된 상태임.
        Assertions.assertThat(logic1).isEqualTo(1);
        Assertions.assertThat(logic2).isEqualTo(1);
    }

    //스코프안해줘도됨 싱글턴이라ㅣ
    @RequiredArgsConstructor
    static class CilientBean {
//        private final PrototypeBean prototypeBean;
        @Autowired
        ApplicationContext applicationContext;

        public int logic(){
            PrototypeBean prototypeBean = applicationContext.getBean(PrototypeBean.class);
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }
    }

    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public void addCount(){
            count++;
        }

        public int getCount(){
            return count;
        }

        @PostConstruct
        public void init(){
            System.out.println("PrototypeBean.init " + this);
        }

        @PreDestroy
        public void destroy(){
            System.out.println("PrototypeBean.destroy");
        }
    }


}
