package kr.or.connect.reservation.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
@EnableTransactionManagement
@PropertySource(value = {"classpath:application.properties"})
public class DBConfig implements TransactionManagementConfigurer {

	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	
	//DataSource Bean 등록
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	/*
	 * 사용자 간의 트랜젝션 처리를 위한 PlatformTransactionManager를 설정하기 위해서는
	 * TransactionManagement Configurer를 구현하고
	 * annotationDrivenTransactionManager 매서드를 오버라이딩 해야함.
	 * 해당 메서드에서 트랜젝션을 처리할
	 * PlatformTransactionManager 객체를 반환하게 해야함.
	 */
	
	@Override
	public TransactionManager annotationDrivenTransactionManager() {
		return transactionManager();
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

}
