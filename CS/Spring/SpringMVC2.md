# 검증
### BindingResult
### FieldEroor
- 오류 발생시 사용자 ㅇ비력 ㄱ밧 저장하는 기능 제공

### ObjectError

MessageCodesResolver

### 오류 코드와 메시지 처리

1. 개발자가 직접 설정한 오류코드 rejectValue() 직접 호출  
2. 스프링이 직접 검증 오류에 추가한 경우(주로 타입 정보가 맞지 않음)

### @Validated
검증기를 실행해 줘

### Form 전송 객체 문리

@RequestBody vs @ModelAttribute

# 로그인

### 쿠키와 보안 문제
- 쿠키값은 임의 변경 가능

사용자별 임의의 토큰(랜덤 값) 노출
서버에서 토큰과 사용자 id 매핑해서 인식
서버에서 토큰 관리

### 세션을 사용해야 한다!
세션: 서버에 중요한 정보를 보관하고 연결을 유지하는 방법

1. 사용자: 로그인(id, pw) 시도
2. 서버: 해당 사용자 맞는지 확인 후 세션 ID 생성(추정 불가능한 UUID)
3. 생성된 세션 ID와 보관할 값을 서버의 세션 저장소에 보관
4. 서버: 세션 id를 응답 쿠키로 전달
5. 클라이언트: 쿠키 저장소에 쿠키 보관

**원과 관련된 정보는 클라이언트에 전달**   
**오직 추적 불가능한 세션 ID만** 

### HttpSession
// 세션이 있으면 있는 세션 반환, 없으면 신규 세션 생성
HttpSession session = request.getSession();
// 세션이 있으면 기존 세션 반환, 없으면 null 반환
HttpSession session = request.getSession(false);

### @SessionAttribute
- 이미 로그인 된 사용자를 찾을 때 사용. 세션을 생성하지는 않음
- 파라미터 앞에 붙임

### 에러처리
ErrorPage 자동 등록  
/error 경로를 기본 오류 페이지로 설정
- BasicErrorController (스프링 컨트롤러) 자동 등록
- 개발자는 오류 페이지만 등록  

뷰 템플릿 위치  
resources/templates/error/500.html  
정적 리소스 위치  
resources/static/error/400.html

### API 예외 처리
