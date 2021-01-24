package hello.core.order;

import hello.member.Grade;
import hello.member.Member;
import hello.member.MemberService;
import hello.member.MemberServiceImpl;
import hello.order.Order;
import hello.order.OrderServiceImpl;
import hello.order.OrderServie;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderServie orderServie = new OrderServiceImpl();

    @Test
    void createOrder(){
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderServie.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
