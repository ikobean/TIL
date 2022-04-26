
# 클라이언트에서 서버로 데이터 전송
## 전송 방식
### 쿼리 파라미터를 통한 데이터 전송
GET방식
정렬 필터(검색어)

### 메시지 바디를 통한 데이터 전송
POST, PUT, PATCH
회원 가입, 주문 등 리소스 등록/변경

## 상황
### 정적 데이터 조회
이미지, 정적 텍스트
### 동적 데이터 조회
검색
### HTML FORM을 통한 데이터 전송
회원 가입 등
GET, POST만 지원
HTML Form submit 시 post 전송
Content-Type: application/x-www.form-urlencoded 사용
form 내용 => 메시지 바디를 통해 전송(key=value, 쿼리스트링)
전송 데이터를 url encoding 처리
Content-Type: multipart/form-data
파일 업로드 같은 바이너리 데이터 전송시 사용
다른 종류의 여러 파일과 폼의 내용을 함꼐 전송 가능

### HTTP API를 통한 데이터 전송
회원 가입
서버 to 서버(백엔드), 앱 클라이언트(iOS, android), 웹 클라이언트(ajax)
html에서 폼전송 대신 js통신에 사용
Content-Type: application/json (사실상 표준)



