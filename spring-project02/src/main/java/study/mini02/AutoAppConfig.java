package study.mini02;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(excludeFilters  = @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = Configuration.class)) //@Component 붙은 친구들을 자동으로 component로 등록해준다.
public class AutoAppConfig {
}
