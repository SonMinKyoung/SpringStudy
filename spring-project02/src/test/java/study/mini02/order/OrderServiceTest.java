package study.mini02.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import study.mini02.member.Grade;
import study.mini02.member.Member;
import study.mini02.member.MemberService;
import study.mini02.member.MemberServiceImpl;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService ;


    @Test
    void createOrder(){
        Long memberId = 3L;
        Member member = new Member(memberId,"Mink", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"apple",5000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

        Member findMember = memberService.findMember(3L);
        Assertions.assertThat(member).isEqualTo(findMember);
    }

}
