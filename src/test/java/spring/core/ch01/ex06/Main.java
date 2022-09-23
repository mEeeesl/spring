package spring.core.ch01.ex06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) { // ▼ 컨테이너 만들기
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Shooter shooter = ctx.getBean("shooter", Shooter.class);
			shooter.fire();
	}
}
