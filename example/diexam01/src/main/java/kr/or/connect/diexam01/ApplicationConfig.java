package kr.or.connect.diexam01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Spring 설정 클래스
@Configuration
public class ApplicationConfig {
	
	//Bean 어노테이션이 붙어있는 메서드들을 자동으로 실행하여 리턴 객체들을 싱글턴으로 관리
	
	@Bean
	public Car car(Engine e) {
		Car c = new Car();
		c.setEngine(e);
		return c;
	}
	
	@Bean
	public Engine engine() {
		return new Engine();
	}
	
}
