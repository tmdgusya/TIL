package hello.core;

import hello.discount.DiscountPolicy;
import hello.discount.RateDiscountPolicy;
import hello.member.MemberService;
import hello.member.MemberServiceImpl;
import hello.member.MemoryMemberRepository;
import hello.order.OrderServiceImpl;
import hello.order.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appconfig {

    @Bean
    public MemoryMemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
