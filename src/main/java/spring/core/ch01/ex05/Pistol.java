package spring.core.ch01.ex05;

import org.springframework.stereotype.Component;

//@Component // 컨테이너가 IOC 하기.
public class Pistol implements Gun {
	@Override
	public void fire() {
		System.out.println("권총 탕탕.");
	}
}

// Bean의 ID는 클래스명(소문자)이다.
