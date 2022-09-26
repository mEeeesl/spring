package spring.core.ch02.ex02;

import org.springframework.stereotype.Component;

@Component // IOC - 메서드나, 객체의 호출작업을 개발자가 하는것이 아닌, 외부에서 결정되는 것. = 스프링 컨테이너가 객체를 생성하도록. + bean으로 등록한다.
public class Rabbit {
	public Result sleep() {
		try {
			Thread.sleep((long)(Math.random() * 1000));
		} catch(Exception e) {}
		
		Result result = new Result();
		result.setResult("zzz");
		
		return result;
	}
}
