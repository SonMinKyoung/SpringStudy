package study.mini02;

import study.mini02.member.Grade;
import study.mini02.member.Member;
import study.mini02.member.MemberService;
import study.mini02.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("newMember = "+ member.getName());
        System.out.println("findMember ="+findMember.getName());
    }
}
