package study.mini02;

//Application의 환경설정에 대한 모든것을 여기에서 다 생성&연결&구성을 책임지는 클래스

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.mini02.discount.RateDiscountPolicy;
import study.mini02.member.MemberService;
import study.mini02.member.MemberServiceImpl;
import study.mini02.member.MemoryMemberRepository;
import study.mini02.order.OrderService;
import study.mini02.order.OrderServiceImpl;
@Configuration //application의 설정정보 라는 의미
public class AppConfig {

    @Bean //설정 정보에 저장된다.
    public MemberService memberService(){

        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    private static RateDiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }


}
