package hello.core.order;

import hello.core.Appconfig;
import hello.core.AutoAppConfig;
import hello.member.*;
import hello.order.Order;
import hello.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderServiceTest {

    Appconfig appconfig = new Appconfig();

    MemberService memberService = appconfig.memberService();
    OrderService orderService = appconfig.orderService();
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoAppConfig.class);

    @BeforeEach
    void beforeEach(){
        memberService = applicationContext.getBean("memberService", MemberService.class);
        orderService = applicationContext.getBean("orderService", OrderService.class);
    }

    @Test
    void createOrder(){
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
