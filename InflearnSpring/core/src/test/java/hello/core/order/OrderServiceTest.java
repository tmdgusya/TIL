package hello.core.order;

import hello.core.Appconfig;
import hello.discount.FixDiscountPolicy;
import hello.member.*;
import hello.order.Order;
import hello.order.OrderServiceImpl;
import hello.order.OrderServie;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    Appconfig appconfig = new Appconfig();

    MemberService memberService = appconfig.memberService();
    OrderServie orderServie = appconfig.orderServie();

    @Test
    void createOrder(){
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderServie.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
