package hello.core.singleton;

import hello.core.Appconfig;
import hello.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingleTon {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        Appconfig appconfig = new Appconfig();
        //1 조회 : 호출할때 마다 생성?

        final MemberService memberService = appconfig.memberService();
        final MemberService memberService1 = appconfig.memberService();

        Assertions.assertThat(memberService).isNotEqualTo(memberService1); // 객체를 요청시마다 생성해줘야됨.
    }
}
