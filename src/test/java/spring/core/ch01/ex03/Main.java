package spring.core.ch01.ex03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.core.ch01.ex02.Shooter;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Shooter shooter1 = ctx.getBean("shooter1", Shooter.class);
		Shooter shooter2 = ctx.getBean("shooter2", Shooter.class);
		
		shooter1.fire();
		shooter2.fire();
	}
}


/*
	AnnotationConfigApplicationContext
	자바 어노테이션을 이용한 클래스로부터, 객체 설정 정보를 가져온다. 
	자바 설정에서 정보를 읽어와, Bean 객체를 생성 및 관리한다.
	
	AppContext에 정의한 @Bean 설정 정보를 읽어와, 객체를 생성 및 초기화 하는 것이다.
	
	getBean() 메서드는,
	AnnotationConfigApplicationContext가 생성한 빈 객체를 검색할 때 사용되며,
	여기서 getBean() 메서드는, 메서드가 생성한 객체를 리턴한다.
  
  
  
*/
