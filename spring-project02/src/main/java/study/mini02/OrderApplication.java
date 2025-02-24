package study.mini02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.mini02.member.Grade;
import study.mini02.member.Member;
import study.mini02.member.MemberService;
import study.mini02.member.MemberServiceImpl;
import study.mini02.order.Order;
import study.mini02.order.OrderService;
import study.mini02.order.OrderServiceImpl;

public class OrderApplication {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Long memberId = 2L;
        Member member = new Member(memberId,"Mink", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"apple",5000);

        System.out.println("order = "+order.toString());
    }
}
