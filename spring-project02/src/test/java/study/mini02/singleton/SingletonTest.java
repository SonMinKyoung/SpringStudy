package study.mini02.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.mini02.AppConfig;
import study.mini02.member.MemberService;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        //1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();
        //2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();
        //참조값이 다르다
        //memberservice1 !=memberService2 -> 객체가 4개 생성된다.
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
    }
}
