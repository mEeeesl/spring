package spring.core.ch02.ex03;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect	// Bean을 지칭.  갖고있는 기능은 Advice + PointCut
@Component // IOC
public class Timer {
	@Before("execution(* spring..*(int))") // 파라미터를 int로 받는 method
	public void clockStart(JoinPoint jp) {
		System.out.println(jp.toShortString() + " - Before");
		System.out.println("시작 시각: " + LocalDateTime.now());
	} // JP 이전 실행
	
	@After("within(spring..Calculator)") // spring 아래 어딘가에 있는 Calculator class의 method
	public void clockEnd(JoinPoint jp) {
		System.out.println(jp.toShortString() + " - After");
		System.out.println("종료 시각: " + LocalDateTime.now());
	} // JP 이후 실행
	
	@AfterReturning(pointcut="bean(calc*)", returning="result") // returning => jp의 리턴값에 이름붙이기(파라미터 변수의 이름)
	public void printResult(JoinPoint jp, int result) {
		System.out.println(jp.toShortString() + ": " + result + " - AfterReturning");
	} // JP 리턴 성공한 후 실행
}


/*

 execution = Method의 pattern을 정의
 (*       => 리턴타입은 뭐가 와도 괜찮고, 
  spring..=> 0개 이상의 Something - ex) spring.core ~ / spring.world.hello ~ 등등
  *(int)) => 파라미터가 int인 모든 Method


 * Advice의 5가지 유형 
 * 
 * @Before (이전) : 어드바이스 타겟 메소드가 호출되기 전에 어드바이스 기능을 수행
 * 
 * @After (이후) : 타겟 메소드의 결과에 관계없이(성공, 예외 관계없이) 타겟 메소드가 완료되면 어드바이스 기능을 수행
 * 
 * @AfterReturning (정상적 반환 이후)타겟 메소드가 성공적으로 결과값을 반환 후에 어드바이스 기능을 수행
 * 
 * @AfterThrowing (예외 발생 이후) 타겟 메소드가 수행 중 예외를 던지게 되면 어드바이스 기능을 수행
 * 
 * @Around (메소드 실행 전후) : 어드바이스가 타겟 메소드를 감싸서 타겟 메소드 호출 전과 후에 어드바이스 기능을 수행




*/