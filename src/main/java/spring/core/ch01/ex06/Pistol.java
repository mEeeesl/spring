package spring.core.ch01.ex06;

import org.springframework.stereotype.Component;

@Component // 이거 붙이면 IOC가 됨
public class Pistol {
	public void fire() {
		System.out.println("권총 탕탕.");
	}
}
