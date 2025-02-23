package study.mini02.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.mini02.AppConfig;

public class MemberServiceTest {

    MemberService memberService ;

    @BeforeEach
    public void BeforeEach(){
        AppConfig appConfig= new AppConfig();
        memberService = appConfig.memberService();
    }
    @Test //회원가입 test
    void join(){
        Member member = new Member(1L,"memberA", Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(2L);

        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
