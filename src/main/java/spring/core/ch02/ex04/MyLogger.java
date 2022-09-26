package spring.core.ch02.ex04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLogger { // 프로젝트시, 팀장만 혼자 만들고, 각종 METHOD를 취합한다함
	private final Logger logger;
	
	public MyLogger() {
		logger = LogManager.getLogger(MyLogger.class);
	}
	
	@After("@annotation(spring.core.ch02.ex04.Log)") // 이거를 JoinPoint로 삼음
	public void log(JoinPoint jp) {
		logger.info(jp.toShortString()); // 작업 시작했다 끝났다 - info
	} // 정상흐름
	
	@AfterThrowing(pointcut="@annotation(spring.core.ch02.ex04.Log)", throwing="ex")
	public void logError(JoinPoint jp, Throwable ex) {
		logger.error(jp.toLongString() + ": " + ex.getMessage());
	} // 예외흐름
}

/* Exception 발생할때 주로 Logger를 남기고, 작업시작과 끝날때 남김.

*/