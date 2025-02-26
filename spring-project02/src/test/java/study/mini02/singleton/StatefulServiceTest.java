package study.mini02.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        statefulService1.order("A",10000);
        statefulService2.order("B",20000);

        int price = statefulService1.getPrice();
        System.out.println("price = " + price);

    }

    static class TestConfig{

        @Bean
        public StatefulService stateFulService(){
            return new StatefulService();
        }
    }

}