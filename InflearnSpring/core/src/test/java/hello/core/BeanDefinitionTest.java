package hello.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class);

    @Test
    @DisplayName("빈 메타 설정정보 확인")
    void findApplicationBean(){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName :beanDefinitionNames){
            BeanDefinition beanDefinition = applicationContext.getBeanDefinition(beanName);
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                System.out.println("beanDefinition = " + beanDefinition + "beanDefinition = " + beanDefinition);
            }
        }
    }
}
