package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam01 {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		System.out.println("초기화 완료!!");
		
		UserBean userBean = (UserBean)ac.getBean("userBean"); // id값 지정, 오브젝트 파일로 리턴하기 때문에 형변환 필요
		
		userBean.setName("kang");
		System.out.println(userBean.getName());
		
		UserBean userBean2 = (UserBean)ac.getBean("userBean");
		
		if (userBean == userBean2)
			System.out.println("같은 인스턴스입니다.");
		System.out.println(userBean2.getName());

	}
}
