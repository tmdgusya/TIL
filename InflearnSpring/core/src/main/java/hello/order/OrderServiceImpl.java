package hello.order;

import hello.discount.DiscountPolicy;
import hello.discount.FixDiscountPolicy;
import hello.member.Member;
import hello.member.MemberRepository;
import hello.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderServie{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discount = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discount);
    }
}