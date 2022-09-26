package spring.core.ch01.ex06;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  // RUNTIME동안 살기
@Target(ElementType.TYPE)	// class 적용
public @interface NoComponent { // Annotation을 직접 만들어서 사용하기
	
}

/* 과제: Java 과제.
 * class에 적용하고, bean 상태에서도 살아남아 있는 annotation을 만들어라.
 * 
 * @Retention 애노테이션은 애노테이션의 라이프 사이클.
 * 즉, 애노테이션이 언제까지 살아 남아 있을지를 정하는 것입니다.
 * */
