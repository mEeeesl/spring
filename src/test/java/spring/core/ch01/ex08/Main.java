package spring.core.ch01.ex08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// Lion - Scope(기본값) - 추가 생성해도, 하나의 bean만 리턴됨. = 객체는 1개뿐.
		Lion lion1 = ctx.getBean(Lion.class);
		Lion lion2 = ctx.getBean(Lion.class);
		
		System.out.println("Lion: " + (lion1 == lion2)); // Lion: true
		
		// Leopard - Scope("singleton")(지정) - 추가 생성해도, 객체는 1개. - bean 1개 
		Leopard leopard1 = ctx.getBean(Leopard.class);
		Leopard leopard2 = ctx.getBean(Leopard.class);
		
		System.out.println("Leopard: " + (leopard1 == leopard2)); // Leopard: true
		
		// Lapin - Scope("prototype") - 추가 생성하면, 객체를 새로 생성 - 새로운 bean을 리턴 - bean n개 
		Lapin lapin1 = ctx.getBean(Lapin.class);
		Lapin lapin2 = ctx.getBean(Lapin.class);
		
		System.out.println("Lapin: " + (lapin1 == lapin2)); // Lapin: false
	} 
}


