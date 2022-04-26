
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
