package kr.or.connect.reservation.config;

import org.springframework.context.annotation.Bean;

/*
 * DispatcherServlet이 읽어들이는 설정
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// DispatcherServlet 이 읽어들이게 될 설정

@Configuration
@EnableWebMvc
@EnableSwagger2
@ComponentScan(basePackages= {"kr.or.connect.reservation.controller"})
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter{

	// URL 요청이 들어오는 것에 따라 처리
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
		registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
		registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
	}
	
	// default servlet handler를 사용하게 합니다. (매핑 정보가 없는 URL 요청이 들어왔을 때)
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	// 특정 URL에 대한 처리를 컨트롤러 클래스를 작성하지 않고 매핑
	@Override
	public void addViewControllers(final ViewControllerRegistry registry) {
		System.out.println("addViewControllers가 호출됩니다.");
		registry.addViewController("/").setViewName("main");
	}
	
	// view resolver가 view의 이름을 가지고 어떤 뷰인지 찾게 해줌
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	/*
	Swagger 사용 시에는 Docket Bean 을 품고있는 설정 클래스 1개가 기본으로 필요하다.
	Spring Boot 에서는 이 기본적인 설정파일 1개로 Swagger 와 Swagger UI 를 함께 사용가능하지만,
	Spring MVC 의 경우 Swagger UI 를 위한 별도의 설정이 필요하다.
	이는, Swagger UI 를 ResourceHandler 에 수동으로 등록해야 하는 작업인데,
	Spring Boot 에서는 이를 자동으로 설정해주지만 Spring MVC 에서는 그렇지 않기 때문이다.
	 */
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.any()) // // 현재 RequestMapping으로 할당된 모든 URL 리스트를 추출
			.paths(PathSelectors.ant("/api/**"))// PathSelectors.any() 를 할경우 모든 경로가 다 사용된다. RestController가 아닌 것 까지 사용된다.
			.build()
			.apiInfo(apiInfo())
			.useDefaultResponseMessages(false);
	}

	/**
	 * API Info
	 */
	private ApiInfo apiInfo() {
		Contact contact = new Contact("LURKS", "https://www.edwith.org", "carami@edwith.org");
		ApiInfo apiInfo =
			new ApiInfo("Reservation Project", "Reservation Test", "Sample Doc 0.1v", "", contact, "This sentence will be display.", "/");
		return apiInfo;
	}
	
	//application.properties 값 사용
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigure() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
}