### URI  

URI: Uniform Resource Identifier  
URL: Uniform Resource Locator  
URN: Uniform Resource Name  

URI는 URL, URN 모두 포함하는 개념  

Uniform: 리소스 식별하는 통일된 방식  
Resource: 자원  
Identifier: 다른 항목과 구분하는데 필요한 정보  
Locator: 리소스가 있는 위치 지정  
Name: 리소스에 이름부여  

URN : isbn을 생각



### URI 구성  

<span style="color:red">scheme</span><span style="color:lightgrey">://[userinfo@]</span><span style="color:orange">host</span><span style="color:yellow">[:port]</span><span style="color:green; ">[/path]</span><span style="color:skyblue">[?query]</span><span style="color:purple;">[#fragment]</span>

<span style="color:red">http://</span><span style="color:orange">www.google.com</span><span style="color:yellow">:433</span><span style="color:green; ">/search</span><span style="color:skyblue">?q=hello&hl=ko</span><span style="color:purple; ">[#fragment]</span>

- ### <span style="color:red;">스키마</span>
  주로 프로토콜 사용</br>
프로토콜 : 어떤 방식으로 자원에 접근할 것인가 하는 약속 규칙

- ### <span style="color:lightgrey">://[userinfo@]</span>
url에 사용자 정보를 포함해서 인증 =>거의 사용 안함

- ### <span style="color:orange">host</span>
호스트명, 도메인명, IP주소

- ### <span style="color:yellow">[:port]</span>
접속 포트, 보통 생략

- ### <span style="color:green;">[/path]</span>
리소스 경로, 계층적 구조

- ### <span style="color:skyblue">[?query]</span>
key=value
?로 시작

- ### <span style="color:purple;">[#fragment]</span>
html 내부 북마크 등에 사용
서버에 전송하는 정보 아님

### 웹 브라우저 요청 흐름

웹브라우저 - 서버

1. http 요청 메세지 생성
2. http 메시지 전송
1. 웹브라우저가 http 메세지 작성
2. socket 라이브러리 통해 전달
  -TCP/IP 연결
  -데이터 전달
3. TCP/IP 패킷 생성 (HTTP 메시지 포함)
4. 요청 패킷 전송
5. 응답 메세지 생성
6. 응답 패킷 전달 
7. 응답 패킷 도착 
8. 랜더링



