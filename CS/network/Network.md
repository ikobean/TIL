
[1. 인터넷 네트워크](#1.-인터넷-네트워크)  
- [IP](#ip)  
- [TCP](#tcp)  
- [UDP](#udp)  
- [DNS](#dns)  

[2. URI와 웹 브라우저 요청 흐름](#2-uri와-웹-브라우저-요청-흐름)
- [URI](#uri)
- [URI구성](#uri-구성)
- [웹 브라우저 요청 흐름](#웹-브라우저-요청-흐름)

[3. HTTP](#3-http)
- [HTTP 특징](#http-특징)  
    - [1. 클라이언트-서버 구조](#1-클라이언트---서버-구조)  
    - [2. 무상태 프로토콜(stateless)](#2-무상태-프로토콜stateless)
    - [3. 비연결성](#3-비-연결성)  

[4. HTTP Method](#4-http-method)
 - [http method 종류](#http-method-종류)
 - [http method 속성](#http-메서드의-속성)
 - [배경지식: 캐시란?](#💡배경-지식)  

[5. HTTP Method 활용](#5-http-method-활용)
- [전송 방식에 따른 분류](#전송-방식에-따른-분류)
- [전송 상황에 따른 분류](#전송-상황에-따른-분류)  


[6. HTTP 상태 코드](#6-http-상태-코드)

# 1. 인터넷 네트워크
### IP 
`Internet Protocol`
 - 지정한 IP 주소(IP Address)에 데이터 전달
 - 패킷(Packet)이라는 통신 단위로 데이터 전달

특징 

 1. 비연결성
 2. 비신뢰성
 3. 프로그램 구분 불가


 **packet 정보**
 출발지 IP, 목적지 IP, 기타..
 전송 데이터

---

### TCP 
`Transmission Control Protocol`
* IP의 부족한 점을 보완하기 위해 나옴
특징 

1. 연결 지향 : tcp - 3 way handshake
클라이언트  <->     서버    
* 1.   → syn 접속 요청 
* 2.  ← syn+ACK      
* 3. →ACK 요청 수락 
 (3과 동시/후) 데이터 전송 

2. 순서 보장 : 잘못된 번호부터 다시 보내줘~ (기본)
3. 데이터 전달 보증


**TCP/IP 패킷 정보**
ip packet : 출발지 IP, 목적지 IP, 기타..
tcp packet : 출발지 PORT, 목적지 PORT 전송 제어, 순서, 검증 정보...
전송 데이터

---
### UDP
`User Datagram Protocol`
* 하얀 도화지
* IP + PORT, 체크섬 정도가 추가된 개념.
* PORT : 같은 IP에서 애플리케이션 구분
  - IP는 아파트 
  - PORT는 동 호수

---
### DNS
`Domain Name System`
* 도메인 명 등록 → IP 주소로 변경
  ex) 200.200.200.01을 지금부터 ikobean.co.kr로 쓸 거야!  


---
# 2. URI와 웹 브라우저 요청 흐름

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


# 
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
---
# 3. HTTP


## HTTP
Hyper Text Transfer Protocol

## History
**HTTP/1.1** 중요
- tcp 기반  

HTTP/2
- tcp기반  

HTTP/3 : ing
- udp기반 (성능 개선)
HTTP 메시지에 모든 것을 전송
ex) html, text, image, json, xml, file, 서버 간 데이터 등

## HTTP 특징
### 1. 클라이언트 - 서버 구조
- Request-Response구조  

### 2. 무상태 프로토콜(stateless)
- 서버가 클라이언트의 상태를 보존하지 않음  
👍: 서버 확장성 높음 (scale out, 수평 확장)  
     (응답 서버가 바뀌어도 상관 없기 때문)  
👎: 클라이언트가 추가 요청시 그 전 데이터도 같이 전송해야 함  
stateless <-> stateful  
stateful - 로그인한 상태 유지해야할 때 등 **최소한만 사용**    

### 3. 비 연결성
connectionless  
요청 - 응답 후 서버는 연결을 끊음(TCP/IP 연결 종료)  
👍: 서버 자원 효율적인 사용  
👎: TCP/IP 새로 연결해야 해서 3 way handshake 시간 추가    
- http 지속 연결로 문제 해결 (http Persistent Connections)  
- http/2, http/3에서 최적화  

### 4. http 메시지  
**요청메시지 예시**
GET /search?1=htllo HTTP/1.1
Host: www.google.com

시작 라인: 종류 - 서버가 수행해야 할 동작 지정 - 버전  

**응답메시지 에시**  
//TODO
HTTP/1.1 200 OK

시작 라인: HTTP 버전 - HTTP 상태코드 - 상태코드

HTTP 헤더: 부가정보
 - 메시지 바디의 내용, 크기, 압축, 인증, 요청 클라이언트(브라우저) 정보 등  
HTTP 바디: 실제 전송할 데이터

### 5. 단순함, 확장 가능

### 💡 배경 지식
> **scale out**
**http 버전 비교**



---
# 4. HTTP Method  

## 좋은 URI 설계란?
**리소스 식별** 이 잘 되는 URI

## 리소스란?  

1. 미네랄을 캐라 에서 **미네랄**  
2. 회원을 삭제해라 에서 **회원**

리소스 - 행위 분리
명사 - 동사 분리

---  

## HTTP Method 종류
### GET 
리소스 조회
요청 데이터 전달 방법: 쿼리 파라미터(쿼리 스트링)

### POST
만능 메서드!  

역할
- 요청 데이터 처리
- 신규 리소스 생성(서버가 아직 식별하지 앟은 새 리소스), 프로세스 처리 등  

요청 데이터 전달 방법: 메시지 바디
❗ 클라이언트가 리소스 위치를 모름. 서버가 생성해 줌.
### PUT
역할
- 리소스 대체, 해당 리소스 없으면 생성  

❗ 클라이언트가 리소스 위치를 알고 URI 지정

### PATCH
리소스 부분 변경

### DELETE
리소스 삭제

그 외 HEAD, OPTIONS, CONNECT, TRACE 가 있음

---

## HTTP method 속성
### 안전
Safe Methods
호출해도 리소스를 변경하지 않음

### 멱등
Idempotent Methods
몇 변을 호출하든 결과가 똑같음
GET, PUT, DELETE만 해당, ❗POST는 아님!!

### 캐시가능
Casheable Methods
응답 결과 리소스를 캐시해서 사용해도 되는가?
GET, HEAD, POST, PATCH 가능

---  

## 💡배경 지식
### 캐시란?
자주 사용하는 데이터나 값을 미리 복사해 놓는 임시 장소
> 
👍 빠른 성능  
👎 저장 공간이 작고 비용이 비쌈


결국 **캐시해서 사용해도 되는가?** 의 의미는 
> 반복적으로 데이터를 불러오는 경우에, 지속적으로 DBMS 혹은 서버에 요청하는 것이 아니라 Memory에 데이터를 저장하였다가 불러다 쓰는 것

**Cache hit:** 요청 데이터가 캐시에 존재해 반환
**Cache miss:** 요청 데이터가 캐시에 없어서 서버/DBMS에 요청

출처: https://mangkyu.tistory.com/69 [MangKyu's Diary]


---

# 5. HTTP Method 활용

## 클라이언트에서 서버로 데이터 전송
### 전송 방식에 따른 분류  
### 1. 쿼리 파라미터를 통한 데이터 전송
- GET방식
- 정렬 필터(검색어)

### 2. 메시지 바디를 통한 데이터 전송
- POST, PUT, PATCH
- 회원 가입, 주문 등 리소스 등록/변경

### 전송 상황에 따른 분류
### 1. 정적 데이터 조회
- 이미지, 정적 텍스트

### 2. 동적 데이터 조회
- 검색
### 3. HTML FORM을 통한 데이터 전송
- 회원 가입 등
- GET, POST만 지원
HTML Form submit 시 post 전송  
form 내용 => 메시지 바디를 통해 전송(key=value, 쿼리스트링) 
- Content-Type: application/x-www.form-urlencoded 사용  
- 전송 데이터를 url encoding 처리  
- Content-Type: multipart/form-data  
파일 업로드 같은 바이너리 데이터 전송시 사용  
다른 종류의 여러 파일과 폼의 내용을 함께 전송 가능  

### 4. HTTP API를 통한 데이터 전송
- 회원 가입
- 서버 to 서버(백엔드), 앱 클라이언트(iOS, android), 웹 클라이언트(ajax)
- html에서 폼전송 대신 js통신에 사용
- Content-Type: application/json (사실상 표준)


# 6. HTTP 상태 코드

**클라이언트는 상위 상태 코드로 해석해서 처리**

## 1xx
### informational
- 요청이 수신되어 처리중

## 2xx
- Succesful
- 요청 정상 처리
### 200 OK
### 201 Created
- 요청 성공 -> 새로운 리소스 생성
### 202 Accepted
- 요청 접수 but 처리가 완료되지는 않음
ex) 배치
### 204 No Content
- 요청 성공 but 응답 페이로드 본문에 보낼 데이터가 없음
ex) 웹 문서 편집기 save 버튼

## 3xx
### Redirection
- 요청을 완료하려면 추가 행동이 필요
- 웹 브라우저는 3xx 응답의 결과에 **Location 헤더가 있으면**, Location 위치로 자동 이동

## 4xx
### Client Error
- 클라이언트 오류, 잘못된 문법 등으로 서버가 요청을 수행할 수 없음

## 5xx
### Server Error
- 서버 오류, 서버가 정상 요청을 처리하지 못함
