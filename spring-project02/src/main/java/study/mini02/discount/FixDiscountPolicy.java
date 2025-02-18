package study.mini02.discount;

import study.mini02.member.Grade;
import study.mini02.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
    private int discontFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP)
            return discontFixAmount;
        else
            return 0;
    }
}
