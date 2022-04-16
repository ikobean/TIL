# Spring MVC1

### HttpServeltRequest, HttpServeletResponse
HTTP 요청 메시지, HTTP 응답 메시지를 편리하게 사용하도록 도와주는 객체.

```java
// 편리한 헤더 조회 방법
private void printHeaderUtils(HttpServletRequest request) {
        System.out.println("--- Header 편의 조회 start ---");    
        System.out.println("[Host 편의 조회]");    
        System.out.println("request.getServerName() = " + request.getServerName()); //Host 헤더    
        System.out.println("request.getServerPort() = " + request.getServerPort()); //Host 헤더
        System.out.println();    
        System.out.println("[Accept-Language 편의 조회]");    
        request.getLocales().asIterator() .forEachRemaining(

            locale -> System.out.println("locale = " + locale));    

            System.out.println("request.getLocale() = " + request.getLocale());    
            System.out.println();   
            System.out.println("[cookie 편의 조회]"); 

            if (request.getCookies() != null) { 
                for (Cookie cookie : request.getCookies()) {            
                    System.out.println(cookie.getName() + ": " + cookie.getValue()); 
                } 
            }    

            System.out.println();    
            System.out.println("[Content 편의 조회]");    
            System.out.println("request.getContentType() = " + request.getContentType());   
            System.out.println("request.getContentLength() = " + request.getContentLength());    
            System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding());    
            System.out.println("--- Header 편의 조회 end ---");   System.out.println(); 
    }
```

### 복수 파라미터에서 단일 파라미터 조회
```java
// 단일 파라미터 조회
request.getParameter(username) = hello 
request.getParameter(age) = 20 

// 이름이 같은 복수 파라미터 조회
request.getParameterValues()
```

content-type은 HTTP 메시지 바디의 데이터 형식을 지정
동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려

### 템플릿 엔진
HTML 문서에서 필요한 곳만 코드를 적용해서 동적으로 변경할 수 있다.
JSP, Thymeleaf, Freemarker, Velocity등

### MVC
- 컨트롤러  
HTTP 요청을 받아서 파라미터를 검증하고, 비즈니스 로직을 실행한다. 그리고 뷰에 전달할 결과 데이터를 조회해서 모델에 담는다.  
- 모델  
뷰에 출력할 데이터를 담아둔다. 뷰가 필요한 데이터를 모두 모델에 담아서 전달해주는 덕분에 뷰는 비즈니스 로직이나 데이터 접근을 몰라도 되고, 화면을 렌더링 하는 일에 집중할 수 있다.    
- 뷰  
모델에 담겨있는 데이터를 사용해서 화면을 그리는 일에 집중한다. 여기서는 HTML을 생성하는 부분을 말한다.  

### SpringMVC 구조  

#### 동작 순서
1. 핸들러 조회: 핸들러 매핑을 통해 요청 URL에 매핑된 핸들러(컨트롤러)를 조회한다. 
2. 핸들러 어댑터 조회: 핸들러를 실행할 수 있는 핸들러 어댑터를 조회한다. 
3. 핸들러 어댑터 실행: 핸들러 어댑터를 실행한다. 
4. 핸들러 실행: 핸들러 어댑터가 실제 핸들러를 실행한다. 
5. ModelAndView 반환: 핸들러 어댑터는 핸들러가 반환하는 정보를 ModelAndView로 변환해서 반환한다. 
6. viewResolver 호출: 뷰 리졸버를 찾고 실행한다. JSP의 경우: InternalResourceViewResolver 가 자동 등록되고, 사용된다. 
7. View 반환: 뷰 리졸버는 뷰의 논리 이름을 물리 이름으로 바꾸고, 렌더링 역할을 담당하는 뷰 객체를 반환한다. JSP의 경우 InternalResourceView(JstlView) 를 반환하는데, 내부에 forward() 로직이 있다. 
8. 뷰 렌더링: 뷰를 통해서 뷰를 렌더링 한다.

@Controller
@RequestMapiing
클래스 레벨에 붙어있는 경우 자동으로 빈 등록

### Jar, War
Jar를 사용하면 항상 내장 서버(톰캣등)을 사용하고, webapp 경로도 사용하지 않습니다  
War를 사용하면 내장 서버도 사용가능 하지만, 주로 외부 서버에 배포하는 목적으로 사용합니다.  

스프링 부트에 Jar를 사용하면 /resources/static/index.hml 위치에 index.html 파일을 두면 Welcome 페이지로 처리해준다.  
(스프링 부트가 지원하는 정적 컨텐츠 위치에 /index.html이 있으면 된다.  

### @Controller
반환 값이 String이면 뷰 이름으로 인식된다. 그래서 뷰를 찾고 뷰가 랜더링 된다.  

### @RestController  
- @RestController 는 반환 값으로 뷰를 찾는 것이 아니라, HTTP 메시지 바디에 바로 입력한다. 따라서 실행 결과로 ok 메세지를 받을 수 있다. @ResponseBody와 관련.
- @Controller 대신에 @RestController 애노테이션을 사용하면, 해당 컨트롤러에 모두 @ResponseBody 가 적용되는 효과가 있다. 따라서 뷰 템플릿을 사용하는 것이 아니라, HTTP 메시지 바디에 직접 데이터를 입력한다. 이름 그대로 Rest API(HTTP API)를 만들 때 사용하는 컨트롤러이다.참고로 @ResponseBody는 클래스 레벨에 두면 전체에 메서드에 적용되는데, @RestController 에노테이션 안에 @ResponseBody가 적용되어 있다.
TODO???@ResponseBody와 관련.


### 로그 사용시 장점
- 쓰레드 정보, 클래스 이름 같은 부가 정보를 함께 볼 수 있고, 출력 모양을 조정할 수 있다.
- 로그 레벨에 따라 개발 서버에서는 모든 로그를 출력하고, 운영서버에서는 출력하지 않는 등 로그를 상황에 맞게 조절할 수 있다.
- 시스템 아웃 콘솔에만 출력하는 것이 아니라, 파일이나 네트워크 등, 로그를 별도의 위치에 남길 수 있다. 
- 특히 파일로 남길 때는 일별, 특정 용량에 따라 로그를 분할하는 것도 가능하다.
- 성능도 일반 System.out보다 좋다. (내부 버퍼링, 멀티 쓰레드 등등) 그래서 실무에서는 꼭 로그를 사용해야 한다.
```java
// 잘못된 사용 예. +연산을 수행함.
log.info("test" + test);

log.info("test", test);
```

### @PathVariable (경로 변수)
파라미터와 변수명이 같은 경우 ("userId") 생략 가능
```java
@GetMapping("/mapping/{userId}")  
public String mappingPath(@PathVariable("userId") String data) {
        log.info("mappingPath userId={}", data); return "ok"; 
}
```

### 미디어 타입 조건 매핑 - HTTP 요청 Content-Type, consume
consumes = "text/plain" 
consumes = {"text/plain", "application/*"} 
consumes = MediaType.TEXT_PLAIN_VALUE
```java
@PostMapping(value = "/mapping-consume", consumes = "application/json") 
public String mappingConsumes() {    
    log.info("mappingConsumes"); return "ok"; 
}
```

### 미디어 타입 조건 매핑 - HTTP 요청 Accept, produce
 **Accept 헤더 기반  Media Type**   
produces = "text/html" *  
produces = "!text/html" *  
produces = "text/*" *  
produces = "*\/*" */  

```java
@PostMapping(value = "/mapping-produce", produces = "text/html") 
public String mappingProduces() {
    log.info("mappingProduces"); return "ok"; 
}
```

MultiValueMap
하나의 키에 여러 값 받을 때 사용

```java
MultiValueMap<String, String> map = new LinkedMultiValueMap();  
map.add("keyA", "value1");  
map.add("keyA", "value2");
````

클라이언트에서 서버로 요청 데이터를 전달할 때는 주로 다음 3가지 방법을 사용한다. 
 **1. GET - 쿼리 파라미터**  
- /url?username=hello&age=20메시지 바디 없이, URL의 쿼리 파라미터에 데이터를 포함해서 전달예) 
- 검색, 필터, 페이징등에서 많이 사용하는 방식   

**2. POST - HTML Form**  
- content-type: application/x-www-form-urlencoded  
- 메시지 바디에 쿼리 파리미터 형식으로 전달 username=hello&age=20예) 
- 회원 가입, 상품 주문, HTML Form 사용  

**3. HTTP message body에 데이터를 직접 담아서 요청**  
- HTTP API에서 주로 사용, JSON, XML, TEXT  
- 데이터 형식은 주로 JSON 사용  
- POST, PUT, PATCH


### @RequestParam  
- 파라미터 이름 지정  
- 요청 파라미터 조회  

### @ResponseBody  
View 조회 무시하고 HTTP message body에 직접 해당 내용 입력  

### @RequestBody  
- 객체 지정 가능

### @ModelAttribute  
+ 요청 파라미터 조회 
HelloData 객체를 생성한다.  
요청 파라미터의 이름으로 HelloData 객체의 프로퍼티를 찾는다.  
그리고 해당 프로퍼티의 setter를 호출해서 파라미터의 값을 입력(바인딩) 한다.  
예) 파라미터 이름이 username이면 setUsername() 메서드를 찾아서 호출하면서 값을 입력한다  
@ModelAttribute - Model 추가  
@ModelAttribute 는 중요한 한가지 기능이 더 있는데, 바로 모델(Model)에 @ModelAttribute로 지정한 객체를 자동으로 넣어준다.  
지금 코드를 보면 model.addAttribute("item", item)가 주석처리 되어 있어도 잘 동작하는 것을 확인할 수 있다

**어노테이션 생략시**  
String , int , Integer 같은 단순 타입 = @RequestParam  
나머지 = @ModelAttribute (argument resolver 로 지정해둔 타입 외)

스프링 MVC는 다음 파라미터를 지원한다.  
- #### HttpEntity  
  - HTTP header, body 정보를 편리하게 조회  
메시지 바디 정보를 직접 조회  
요청 파라미터를 조회하는 기능과 관계 없음 @RequestParam X, @ModelAttribute X  
HttpEntity는 **응답에도 사용 가능**(http 메시지 바디에 직접 응답 데이터 출력)  
메시지 바디 정보 직접 반환헤더 정보 포함 가능view 조회X  
HttpEntity 를 상속받은 다음 객체들도 같은 기능을 제공한다.  
- RequestEntity  
  - HttpMethod, url 정보가 추가, 요청에서 사용  
- ResponseEntity  
  - HTTP 상태 코드 설정 가능, 응답에서 사용  
return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.CREATED)

### HTTP 응답 - 정적 리소스, 뷰 템플릿
스프링(서버)에서 응답 데이터를 만드는 방법
1. 정적 리소스
- html, css, js 등
- 해당 파일을 변경 없이 그대로 서비스  
2. 뷰 템플릿
- 동적 html 제공
- 요청 -> 뷰 템플릿 -> html 생성 -> 응답
- 스프링 부트 기본 뷰 템플릿 : src/main/resources/templates
3. http 메시지 사용
- http API (데이터 전달)

### HTTP 메시지 컨버터 인터페이스
ByteArrayHttpMessageConverter : byte[] 데이터를 처리한다  
StringHttpMessageConverter : String 문자로 데이터를 처리한다.  
MappingJackson2HttpMessageConverter : application/json  



### PRG 방식
Post/ Redirect/ Get

RedirectAttributes
- URL 인코딩도 해주고, pathVarible, 쿼리 파라미터까지 처리해준다
