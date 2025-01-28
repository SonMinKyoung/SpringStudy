package study.mini01.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import study.mini01.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository memberRepo = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        memberRepo.clearStore();
    }
    @Test
    public void save(){
        //given
        Member member = new Member();
        member.setName("winter");
        //when
        memberRepo.save(member);
        //then
        Member result = memberRepo.findbyId(member.getId()).get();
        //System.out.println("Result ="+(result=member)); > 매번 확인 할 수 없다.
//        Assertions.assertEquals(member,null);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring");
        memberRepo.save(member1);

        Member member2 = new Member();
        member2.setName("summer");
        memberRepo.save(member2);

        Member result = memberRepo.findbyName("summer").get();

        assertThat(result).isEqualTo(member2);

    }
    @Test
    public void findAll(){
        Member member1 = new Member();
        Member member2 = new Member();
        member1.setName("spring");
        member2.setName("summer");

        memberRepo.save((member1));
        memberRepo.save(member2);

        List<Member> result = memberRepo.findAll();
        assertThat(result.size()).isEqualTo(2);

    }
}
//모든 테스트는 메소드 순서 지정이 안된다-> test 끝낸 후 데이터 삭제를 해야한다.>>AfterEach 호출
