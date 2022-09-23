package spring.core.ch01.ex06;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "spring.core.ch01.ex06",			// 여기 Scan 할 건데,
		excludeFilters = @Filter(type = FilterType.ANNOTATION,  // Annotation 뺄거야
						classes = (NoComponent.class))) 		// NoComponent 이름의 어노테이션을 뺸다
public class AppConfig {

}

// Rifle은 안쓸거고, Pistol은 쓰게끔 하자.