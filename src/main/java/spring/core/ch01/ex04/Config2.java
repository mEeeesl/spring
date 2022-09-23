package spring.core.ch01.ex04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.core.ch01.ex01.Rifle;

@Configuration
public class Config2 { // 흩어져있는 Config를, 통합시키는 방법.
	@Bean
	public Rifle rifle() {
		return new Rifle();
	}
}
