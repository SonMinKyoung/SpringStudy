package study.mini02;

//Application의 환경설정에 대한 모든것을 여기에서 다 생성&연결&구성을 책임지는 클래스

import study.mini02.discount.RateDiscountPolicy;
import study.mini02.member.MemberService;
import study.mini02.member.MemberServiceImpl;
import study.mini02.member.MemoryMemberRepository;
import study.mini02.order.OrderService;
import study.mini02.order.OrderServiceImpl;

public class AppConfig {


    public MemberService memberService(){

        return new MemberServiceImpl(memberRepository());
    }

    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private static RateDiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }


}
