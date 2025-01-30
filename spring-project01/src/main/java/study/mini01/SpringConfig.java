package study.mini01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.mini01.repository.MemberRepository;
import study.mini01.repository.MemoryMemberRepository;
import study.mini01.service.MemberService;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}
