package spring.core.ch02.ex02;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // 부가기능 모듈 ( Advice(기능)을 + PointCut(어디에 적용할지))
@Component // IOC - 스프링 컨테이너가 객체를 생성하도록. + bean으로 등록한다.
public class Timer { // 시간 측정하는 부가기능 모듈
	@Pointcut("execution(public * spring.core.ch02.ex02..*(..))") // PointCut - Advice(기능)을 적용할 Joint Point(대상,메소드)를 지정하는 기능 
	private void myPointcut() {}
	// "execution( public *  =>  public에 리턴타입은 뭐든 괜찮고 
	//			  spring.core.ch02.ex02..*(..))" 
	//				=> ~ ex02의 어떤 클래스의 어떤 메서드도 괜찮고 어떤 파라미터들도 다 괜찮다. 
	//		★ PointCut = 그곳에 적용시킬것이다.  ( JointPoint의 상세 스펙을 정의 )
	
	@Around("myPointcut()") // 관심사항의 "대상 지정"과 "적용 시점"을 지정한다. ( PointCut=대상지정, Advice=적용시점 )
	public Object clock(ProceedingJoinPoint jp) throws Throwable { // 컨테이너가 clock을 call함
		System.out.println(jp.getSignature()); // 메소드의 시그니처 (리턴타입, 이름, 매개변수) 정보가 저장된 Signature 객체리턴 - getSignature() 
		
		long start = System.currentTimeMillis();
		Result result = (Result)jp.proceed(); // clock이 JoinPoint 실행
		long end = System.currentTimeMillis();
		
		System.out.println("경과시간: " + (end - start));
		
		result.setResult(result.getResult() + "(clock)");
		return result;
	}	
}

/* AOP용어 총 정리
 * Aspect - 부가기능 모듈 ( 부가될 기능을 정의한 Advice + Advice를 어디에 적용할지 결정하는 PointCut을 함께 지님 )
 * Advice - 실질적으로 부가기능을 담은 구현체, Advice는 Aspect가 무엇을 "언제"할지를 정의한다.
 * Target - Aspect가 가지고있는 Advice(부가기능)을 부여할 대상(class or method).
 * JointPoint - Advice(기능)이 적용될 수 있는 위치 (메서드 실행 시점이 가장 흔함)
 * PointCut - Advice(기능)을 적용할 Joint Point(대상, 메소드)를 선별하는 기능. 
 * 			  (JointPoint의 상세 스펙을 정의한 것, 구체적으로 Advice가 실행될 지점을 정함)			
 * 			  ("A 클래스에 B 메서드를 적용할 때 호출해라") 
 * Proxy -  Target을 감싸서 Target의 요청을 대신 받아주는 Wrapping 객체.
 * 			Client에서 Target을 호출하게 되면 Target을 감싸고 있는 Proxy가 호출되어,
 * 	 		Target 메소드를 실행하기 전에 전처리하고, Target메소드를 실행하고 후처리를 실행하도록 구성
 * 
 * @Component - 컴포넌트 어노테이션을 명시해 스프링 컨테이너가 객체 생성하도록 한다. 
 * @Aspect - 스프링 컨테이너에 AOP 담당 객체임을 알린다.
 * @Around - 관심사항의 대상 지정과 적용 시점을 지정한다. (PointCut, Advice)
 * 
 * @Around("myPointcut()")  //  관심사항의 대상 지정과 적용 시점을 지정한다. (PointCut, advice)
 * 							//  Advice : 관심사항 "적용 시점" ( ex. 메서드 실행 전, 후, 리 턴 시, 예외 발생 시)
 * 							//  PointCut : 관심사항 "적용 대상" 지정 (execution, within, bean)
 * 
 * @Before (이전) : 어드바이스 타겟 메소드가 호출되기 전에 어드바이스 기능을 수행
 * @After (이후) : 타겟 메소드의 결과에 관계없이(성공, 예외 관계없이) 타겟 메소드가 완료되면 어드바이스 기능을 수행
 * @AfterReturning (정상적 반환 이후)타겟 메소드가 성공적으로 결과값을 반환 후에 어드바이스 기능을 수행
 * @AfterThrowing (예외 발생 이후) 타겟 메소드가 수행 중 예외를 던지게 되면 어드바이스 기능을 수행
 * @Around (메소드 실행 전후) : 어드바이스가 타겟 메소드를 감싸서 타겟 메소드 호출 전과 후에 어드바이스 기능을 수행
 * 
 * proceed() 의 리턴 값은 Object 이다.
 * 이는 Aspect 로 연결된 Original Method 의 리턴 값을 받을 수 있으며, 받을 때는 형변환이 필요하다.
 * 
 * 횡단 관심사 : 다수의 모듈에 공통적으로 나타나는 부분
 * 핵심 관심사 : 각 의사 코드에서만 나타나는 부분
 * 코드 = 핵심 관심사 + 횡단 관심사
 * 
 */
