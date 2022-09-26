package spring.core.ch02.ex04;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
	@Log // JoinPoint 지정
	public void add() {
		System.out.println(1 + 2);
	}
	
	public void minus() {
		System.out.println(1 - 2);
	}
	
	@Log // JoinPoint 지정
	public void divide() {
		int result = 1 / 0; // NullPointException 발생
		System.out.println(result); // Exception으로인해 실행못함
	}
}
