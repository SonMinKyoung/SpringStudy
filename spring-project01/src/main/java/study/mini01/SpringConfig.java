package study.mini01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.mini01.repository.JdbcMemberRepository;
import study.mini01.repository.MemberRepository;
import study.mini01.repository.MemoryMemberRepository;
import study.mini01.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new JdbcMemberRepository(dataSource);
    }

}
