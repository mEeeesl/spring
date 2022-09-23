package spring.core.ch01.ex03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.core.ch01.ex01.Pistol;
import spring.core.ch01.ex01.Rifle;
import spring.core.ch01.ex02.Shooter;
				// ↙ 해당 클래스(AppContext)를 스프링 설정 클래스로 지정한다.
@Configuration 	// ← 설정 파일을 만들거나, Bean을 등록하기 위한 Annotation
public class AppConfig {
	//IOC 할 Bean들 선언, Configuration의 메서드들은 ID이기에 명사형태로 사용한다.
	@Bean
	public Pistol pistol() { // pistol< 이건 Id임
		return new Pistol();
	}
	
	@Bean
	public Rifle rifle() {
		return new Rifle();
	}
	
	@Bean
	public Shooter shooter1() { // shooter1 < Id임 
		return new Shooter("최한석", pistol()); // pistol()하면 new Pistol 되니 Gun gun이 됨
	}
	// 컨테이너는 싱글톤으로 저장하기 때문에 중복안되고 ID별로 1개씩 갖고있다한다.
	// 있으면 있는거 쓰고 , 없으면 새로 만든다.
	
	@Bean
	public Shooter shooter2() {
		Shooter shooter = new Shooter();
		shooter.setName("한아름");
		shooter.setGun(rifle());
		
		return shooter;
	}
}

/*
 	@Bean으로 넣어버리면 알아서 Call 해버림, 그래서 자동으로 new Pistol()이 생김.
 
	Spring은 객체를 생성하고, 초기화하는 기능을 제공한다.
	@Bean 이하의 코드가 한 개의 객체를 생성하고 초기화하는 설정을 담고 있다.
	
 	스프링이 생성하는 객체를 Bean 객체라고 한다.
 	
 	@Bean 어노테이션이 붙으면 해당 메서드가 생성한 객체를 스프링이 관리하는
 	bean 객체로 등록한다.
 	
 	Bean 어노테이션을 붙인 메서드의 이름은, bean 객체를 구분할 때 사용된다.
*/
