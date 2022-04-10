**클라이언트는 상위 상태 코드로 해석해서 처리**

# 1xx
### informational
- 요청이 수신되어 처리중

# 2xx
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

# 3xx
### Redirection
- 요청을 완료하려면 추가 행동이 필요
- 웹 브라우저는 3xx 응답의 결과에 **Location 헤더가 있으면**, Location 위치로 자동 이동

# 4xx
### Client Error
- 클라이언트 오류, 잘못된 문법 등으로 서버가 요청을 수행할 수 없음

# 5xx
### Server Error
- 서버 오류, 서버가 정상 요청을 처리하지 못함
