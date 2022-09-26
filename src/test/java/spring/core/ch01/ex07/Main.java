package spring.core.ch01.ex07;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		// Lion is born. - 컨테이너 생성시 afterPropertiesSet() 실행
		
		Lion lion = ctx.getBean(Lion.class); // Lion bean이 1개밖에 없으니 바로 찾을 수 있음
		lion.shout(); // Lion shout.
		
		ctx.close(); // Lion is dead. 컨테이너가 죽기전에 destroy() 실행
	}
}
