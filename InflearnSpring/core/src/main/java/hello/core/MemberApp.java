package hello.core;

import hello.member.Grade;
import hello.member.Member;
import hello.member.MemberService;
import hello.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member memeber = memberService.findMemeber(memberA.getId());
        System.out.println("memeber.getName().equals(memberA.getName()) = " + memeber.getName().equals(memberA.getName()));
    }
}
