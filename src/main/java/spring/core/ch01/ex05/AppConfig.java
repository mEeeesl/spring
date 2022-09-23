package spring.core.ch01.ex05;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration	// 각 클래스마다 Annotation 머 해가지고 Bean은 못쓴대.
@ComponentScan("spring.core.ch01.ex05")	// 그래서 이걸 씀, 어떤걸 스캔해야하는지 알려주기
public class AppConfig {

}

// hr 과제할땐, @ComponentScan("com.my.hr") 이렇게 하면됨.