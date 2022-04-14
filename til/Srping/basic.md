객체지향 설계 원칙
1. SRP 단일 책임 원칙
한 클래스는 하나의 책임만 가져야 한다
2. OCP 개방 폐쇄 원칙
3. L
4. Inversion of Control 제어의 역전
듯 프로그램의 제어 흐름을 직접 제어하는 것이 아니라 외부에서 관리하는 것
5. DIP 의존관계 역전 원칙
프로그래머는 “추상화에 의존해야지, 구체화에 의존하면 안된다.” 의존성 주입은 이 원칙을 따르는 방법 중
하나다

#### annotation
@Configuration 
설정 클래스에 붙여준다. (Appconfig)
없이 bean 어노테이셔만 적용하는 경우 싱글톤 보장이 되지 않는다.
@Configuration과 바이트코드 조작의 마법

@Bean 
각 메서드에 붙여주면 스프링 컨테이너에 스프링 빈으로 등록한다

```java
ApplicationContext ac = AnnotationConfigApplicationContext(AppConfig.class);
AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
```

스프링 컨테이너는 @Configuration 이 붙은 AppConfig 를 설정(구성) 정보로 사용한다. 
여기서 @Bean 이라 적힌 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록한다. 
이렇게 스프링 컨테이너에 등록된 객체를 스프링 빈이라 한다.
스프링 빈은 @Bean 이 붙은 메서드의 명을 스프링 빈의 이름으로 사용한다. 


#### 싱글톤 패턴
클래스의 인스턴스가 딱 1개만 생성되는 것을 보장하는 디자인 패턴이다.
그래서 객체 인스턴스를 2개 이상 생성하지 못하도록 막아야 한다.
private 생성자를 사용해서 외부에서 임의로 new 키워드를 사용하지 못하도록 막아야 한다

```java

public class SingletonService {

    //1. static 영역에 객체를 딱 1개만 생성해둔다.
    private static final SingletonService instance = new SingletonService();

    //2. public으로 열어서 객체 인스터스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용한다.
    public static SingletonService getInstance() {
        return instance;
    }
    
    //3. 생성자를 private으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
```

#### 싱글톤 컨테이너
스프링 컨테이너는 싱글턴 패턴을 적용하지 않아도, 객체 인스턴스를 싱글톤으로 관리한다.
이전에 설명한 컨테이너 생성 과정을 자세히 보자. 컨테이너는 객체를 하나만 생성해서 관리한다.
스프링 컨테이너는 싱글톤 컨테이너 역할을 한다. 이렇게 싱글톤 객체를 생성하고 관리하는 기능을 싱글톤
레지스트리라 한다.
스프링 컨테이너의 이런 기능 덕분에 싱글턴 패턴의 모든 단점을 해결하면서 객체를 싱글톤으로 유지할 수
있다.
싱글톤 패턴을 위한 지저분한 코드가 들어가지 않아도 된다.
DIP, OCP, 테스트, private 생성자로 부터 자유롭게 싱글톤을 사용할 수 있다

싱글톤 주의사항
싱글톤 패턴이든, 스프링 같은 싱글톤 컨테이너를 사용하든, 객체 인스턴스를 하나만 생성해서 공유하는
싱글톤 방식은 여러 클라이언트가 하나의 같은 객체 인스턴스를 공유하기 때문에 싱글톤 객체는 상태를
유지(stateful)하게 설계하면 안된다.
무상태(stateless)로 설계해야 한다!
특정 클라이언트에 의존적인 필드가 있으면 안된다.
특정 클라이언트가 값을 변경할 수 있는 필드가 있으면 안된다!
가급적 읽기만 가능해야 한다.
필드 대신에 자바에서 공유되지 않는, 지역변수, 파라미터, ThreadLocal 등을 사용해야 한다.
스프링 빈의 필드에 공유 값을 설정하면 정말 큰 장애가 발생할 수 있다!!


```java
@ComponentScan(
 excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
```
아래 어노테이션 붙은 애들을 다 자동으로 등록해줌
@Component 붙은 애들을 자동으로 bean으로 등록해줌
컴포넌트 스캔을 사용하면 @Configuration 이 붙은 설정 정보도 자동으로 등록
@Component : 컴포넌트 스캔에서 사용
@Controlller : 스프링 MVC 컨트롤러에서 사용
@Service : 스프링 비즈니스 로직에서 사용
@Repository : 스프링 데이터 접근 계층에서 사용
@Configuration : 스프링 설정 정보에서 사용


com.hello
com.hello.serivce
com.hello.repository
com.hello 프로젝트 시작 루트, 여기에 AppConfig 같은 메인 설정 정보를 두고, 
@ComponentScan 애노테이션을 붙이고, basePackages 지정은 생략한다.
이렇게 하면 com.hello 를 포함한 하위는 모두 자동으로 컴포넌트 스캔의 대상이 된다. 그리고 프로젝트
메인 설정 정보는 프로젝트를 대표하는 정보이기 때문에 프로젝트 시작 루트 위치에 두는 것이 좋다
생각한다.

스프링 부트를 사용하면 스프링 부트의 대표 시작 정보인 @SpringBootApplication 를 이
프로젝트 시작 루트 위치에 두는 것이 관례이다. (그리고 이 설정안에 바로 @ComponentScan 이 들어있다!)

다양한 의존관계 주입 방법
의존관계 주입은 크게 4가지 방법이 있다.
생성자 주입
수정자 주입(setter 주입)
필드 주입
일반 메서드 주입

특징
생성자 호출시점에 딱 1번만 호출되는 것이 보장된다.
불변, 필수 의존관계에 사용
중요! 생성자가 딱 1개만 있으면 @Autowired를 생략해도 자동 주입 된다. 물론 스프링 빈에만 해당한다.

수정자 주입(setter 주입)
setter라 불리는 필드의 값을 변경하는 수정자 메서드를 통해서 의존관계를 주입하는 방법이다.
특징
선택, 변경 가능성이 있는 의존관계에 사용
자바빈 프로퍼티 규약의 수정자 메서드 방식을 사용하는 방법이다

참고: @Autowired 의 기본 동작은 주입할 대상이 없으면 오류가 발생한다. 주입할 대상이 없어도 동작하게
하려면 @Autowired(required = false) 로 지정하면 된다.

필드 주입
이름 그대로 필드에 바로 주입하는 방법이다.
특징
코드가 간결해서 많은 개발자들을 유혹하지만 외부에서 변경이 불가능해서 테스트 하기 힘들다는
치명적인 단점이 있다.
DI 프레임워크가 없으면 아무것도 할 수 없다.
사용하지 말자!
애플리케이션의 실제 코드와 관계 없는 테스트 코드
스프링 설정을 목적으로 하는 @Configuration 같은 곳에서만 특별한 용도로 사용

@RequiredArgsConstructor 기능을 사용하면 final이 붙은 필드를 모아서
생성자를 자동으로 만들어준다. 

조회 대상 빈이 2개 이상일 때 해결 방법
@Autowired 필드 명 매칭
@Qualifier @Qualifier끼리 매칭 빈 이름 매칭
@Primary 사용


### 💡정확히 알고 가자

ConcurrentHashMap
static
private 
생성자
assertThat 의 isSameAs 와 isEqualTo
