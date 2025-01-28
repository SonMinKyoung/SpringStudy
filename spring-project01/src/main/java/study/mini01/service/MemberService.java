package study.mini01.service;

import study.mini01.domain.Member;
import study.mini01.repository.MemberRepository;
import study.mini01.repository.MemoryMemberRepository;

import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    회원가입
    public Long join(Member member){
        //같은 이름이 있는 중복 회원X
        /*Optional<Member> result= memberRepository.findbyName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        });*/
        memberRepository.findbyName(member.getName())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다");
                        });

        memberRepository.save(member);
        return member.getId();
    }
}
