package hello.core.member;

import hello.core.Appconfig;
import hello.member.Grade;
import hello.member.Member;
import hello.member.MemberService;
import hello.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberServiceTest {

    MemberService memberService;
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class);

    @BeforeEach
    void beforeEach(){
        memberService = applicationContext.getBean("memberService", MemberService.class);
    }

    @Test
    void join(){
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when
        memberService.join(member);
        //then
        Member findMember = memberService.findMemeber(1L);
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
