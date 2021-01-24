package hello.core;

import hello.discount.DiscountPolicy;
import hello.discount.FixDiscountPolicy;
import hello.member.MemberService;
import hello.member.MemberServiceImpl;
import hello.member.MemoryMemberRepository;
import hello.order.OrderServiceImpl;
import hello.order.OrderServie;

public class Appconfig {

    public MemoryMemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    public OrderServie orderServie(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
