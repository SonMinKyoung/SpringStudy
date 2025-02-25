package study.mini02.beanfind;
/* Test 02 */
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.mini02.AppConfig;
import study.mini02.member.MemberService;
import study.mini02.member.MemberServiceImpl;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        //Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        //public class MemberServiceImpl implements MemberService 이기 떄문에
    }

    @Test
    @DisplayName("이름없이 타입만으로 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("구체 타입만으로 조회") //변경 시 유연성이 떨어진다. 최대한 지양
    void findBeanByName2(){
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회ㅌ")
    void findBeanByNameㅌ(){
        //MemberService memberService = ac.getBean("xxxx", MemberService.class);

        assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("xxxx", MemberService.class));

        //public class MemberServiceImpl implements MemberService 이기 떄문에
    }

}
