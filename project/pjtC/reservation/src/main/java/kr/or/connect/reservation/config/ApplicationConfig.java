package kr.or.connect.reservation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/*
 * dao, service에 구현된 컴포넌트들을 읽어옴.
 * 해당 기능들이 수행될 때 내부적으로 DBConfig에 사용된 것들을 써야 하므로
 * 해당 부분을 Import 해줌.
 */

@Configuration
@ComponentScan(basePackages = {"kr.or.connect.reservation.dao" , "kr.or.connect.reservation.service"})
@Import({DBConfig.class})
public class ApplicationConfig {

}
