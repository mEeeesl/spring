package spring.core.ch01.ex04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import spring.core.ch01.ex01.Gun;
import spring.core.ch01.ex02.Shooter;

@Configuration
@Import({Config1.class, Config2.class}) // 흩어져있는 Configuration을 통합시키기.
public class AppConfig { // 총 3개의 Configuration이 하나로 통합되는 것이다. 
	@Autowired private Gun pistol; // 멤버변수
	@Autowired private Gun rifle;
	
	@Bean
	public Shooter shooter1() {
		return new Shooter("최한석", pistol); // 여기서 pistol은 멤버변수 pistol
	}
	
	@Bean
	public Shooter shooter2() {
		Shooter shooter = new Shooter();
		shooter.setName("한아름");
		shooter.setGun(rifle);
		
		return shooter;
	}
}

/*
 * @Autowired - DI목적
 * 멤버변수 선언하고 위에 붙이면,
 * 컨테이너는 해당 녀석을 찾아서 DI를 시켜준다.
 * 
 * @Autowired란, 스프링 DI(Dependency Injection)에서 사용되는 어노테이션입니다.  
 *  
 * 슈터1 슈터2는 Bean으로 선언한다 지금은.
 * */

/* IOC - @Component
 * DI  - @Autowired
 * 
 * 즉, 해당 변수 및 메서드에 스프링이 관리하는 Bean을 자동으로 매핑해주는 개념입니다.
 * @Autowired 는 변수, Setter메서드, 생성자, 일반 메서드에 적용이 가능하며,
 * <property>, <constructor-arg>태그와 동일한 역할을 합니다. 
 * 
 * 
 * 
 * */

