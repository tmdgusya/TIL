package hello.discount;

import hello.member.Member;
import jdk.jfr.Event;

public interface DiscountPolicy {

    /*
    * @return 할인 대상 금액
    * */
    int discount(Member member, int price);
}
