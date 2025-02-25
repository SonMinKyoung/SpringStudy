package study.mini02.beanfind;
/*Test 01 */
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.mini02.AppConfig;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class
    );
    @Test
    @DisplayName("모든 Bean 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        //iter +tap : 배열이 있을 때, for문 자동완성
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);

            System.out.println("name = " + beanDefinitionName + "object = "+ bean );
            //soutv
        }

        System.out.println("사용된 Bean 총 길이 = " + beanDefinitionNames.length);
    }

    @Test
    @DisplayName("Application Bean 출력하기")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        int count =0;
        //iter +tap : 배열이 있을 때, for문 자동완성
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                count++;
                System.out.println("application bean name = " + beanDefinitionName + "object = "+ bean );
            }
            //soutv
        }
        System.out.println("count app = " + count);

    } @Test
    @DisplayName("Infrastructure Bean 출력하기")
    void findInfrastructureBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        int count =0;
        //iter +tap : 배열이 있을 때, for문 자동완성
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if(beanDefinition.getRole()==BeanDefinition.ROLE_INFRASTRUCTURE){
                Object bean = ac.getBean(beanDefinitionName);
                count ++;
                System.out.println("infra bean name = " + beanDefinitionName + "object = "+ bean );
            }

            //soutv
        }
        System.out.println("count infra = " + count);

    }
}
