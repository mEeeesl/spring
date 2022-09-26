package spring.core.ch02.ex02;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("spring.core.ch02.ex02")
@EnableAspectJAutoProxy // @Aspect @Around @Pointcut를 읽어들일수있게함
public class AppConfig {

}
