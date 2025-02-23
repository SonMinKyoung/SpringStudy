package study.mini02.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.mini02.member.Grade;
import study.mini02.member.Member;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("vip는 10%할인이 적용되어야한다.")
    void vipTest(){
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        int count =discountPolicy.discount(member, 10000);
        Assertions.assertThat(count).isEqualTo(1000);
    }
    @Test@DisplayName("basic은 할인이 적용되지 않는다.")
    void basicTest(){
        Member member = new Member(2L, "memberBasic", Grade.BASIC);
        int count = discountPolicy.discount(member, 10000);

        Assertions.assertThat(count).isEqualTo(0);
    }

}