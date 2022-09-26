package spring.core.ch01.ex07;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Lion implements InitializingBean, DisposableBean {	// Spring에서 기본으로 제공하는 속성을 상속
	@Override
	public void afterPropertiesSet() throws Exception { // bean이 준비되면 호출되는 method
		System.out.println("Lion is born.");
	}
	
	public void shout() {
		System.out.println("Lion shout.");
	}
	
	@Override
	public void destroy() throws Exception { // destroy - bean이 죽기전에 청소하려고 호출하는 method
		System.out.println("Lion is dead.");
	}
}
