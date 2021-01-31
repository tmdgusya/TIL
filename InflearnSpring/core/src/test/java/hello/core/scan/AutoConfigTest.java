package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.member.MemberService;
import hello.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoConfigTest {

    @Test
    void basiScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        final MemberServiceImpl bean = ac.getBean(MemberServiceImpl.class);
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
