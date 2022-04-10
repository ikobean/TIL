
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

## 특징
### 1. 클라이언트 - 서버 구조
- Request-Response구조  

### 2. 무상태 프로토콜(stateless), 비연결성  
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



