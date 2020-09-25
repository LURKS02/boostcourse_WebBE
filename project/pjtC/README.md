### WebMvcConfigurerAdapter와 WebMvcConfigurer
 WebMvcConfigurer 인터페이스는 10개 이상의 메서드를 갖고 있는데, 각 메서드는 담당하는 설정 부분이 서로 다르다.
이떄 WebMvcConfigurer 인터페이스를 implement하여 필요한 메서드만 구현하고 나머지 메서드는 빈 구현으로 할 수 있지만, 이 경우 불필요한 코드를 만들게 된다.
따라서 불필요한 코드를 만들지 않기 위해 WebMvcConfigurerAdapter 클래스를 사용한다. 

WebMvcConfigurerAdapter 클래스는 WebMvcConfigurer 인터페이스를 상속하며, 모든 메서드의 빈 구현을 미리 만들어놓았다. 따라서 WebMvcConfigurerAdapter 클래스를 extends 해서 필요한 메소드만 오버라이딩 해줄 수 있다.
