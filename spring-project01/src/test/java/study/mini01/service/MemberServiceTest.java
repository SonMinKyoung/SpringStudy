package study.mini01.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.mini01.domain.Member;
import study.mini01.repository.MemoryMemberRepository;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
//test는 한글로 적어도 상관없음.
    MemberService memberService;
    MemoryMemberRepository memberRepo;
    @BeforeEach
    public void beforeEach(){
        memberRepo = new MemoryMemberRepository();
        memberService = new MemberService(memberRepo);
    }
    @AfterEach
    public void afterEach(){
        memberRepo.clearStore();
    }

    @Test/*회원가입*/
    public void join() {
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test/*중복회원*/
    public void valiadMember() throws Exception{
        //given

        //when
        //then
    }

    @Test
    void findOne() {
        //given
        Member member1 = new Member();
        member1.setName("spring");
        memberRepo.save(member1);

        Member member2 = new Member();
        member2.setName("spring");
        memberRepo.save(member2);

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));//예외가 발생해야 한다.
        assertThrows(IllegalStateException.class,() -> memberService.join(member2));
       /* try{
            memberService.join(member2);
            fail();
        }catch(IllegalStateException e) {
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        };*/
        //then
    }
}