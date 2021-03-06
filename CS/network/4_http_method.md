
# 좋은 URI 설계란?
**리소스 식별** 이 잘 되는 URI

# 리소스란?  

1. 미네랄을 캐라 에서 **미네랄**  
2. 회원을 삭제해라 에서 **회원**

리소스 - 행위 분리
명사 - 동사 분리

# HTTP 메서드 종류
## GET 
리소스 조회
요청 데이터 전달 방법: 쿼리 파라미터(쿼리 스트링)

## POST
만능 메서드!  

역할
- 요청 데이터 처리
- 신규 리소스 생성(서버가 아직 식별하지 앟은 새 리소스), 프로세스 처리 등  

요청 데이터 전달 방법: 메시지 바디
❗ 클라이언트가 리소스 위치를 모름. 서버가 생성해 줌.
## PUT
역할
- 리소스 대체, 해당 리소스 없으면 생성  

❗ 클라이언트가 리소스 위치를 알고 URI 지정

## PATCH
리소스 부분 변경

## DELETE
리소스 삭제

그 외 HEAD, OPTIONS, CONNECT, TRACE 가 있음

# HTTP 메서드의 속성
## 안전
Safe Methods
호출해도 리소스를 변경하지 않음

## 멱등
Idempotent Methods
몇 변을 호출하든 결과가 똑같음
GET, PUT, DELETE만 해당, ❗POST는 아님!!

## 캐시가능
Casheable Methods
응답 결과 리소스를 캐시해서 사용해도 되는가?
GET, HEAD, POST, PATCH 가능


# 💡배경 지식
## 캐시란?
자주 사용하는 데이터나 값을 미리 복사해 놓는 임시 장소
>
👍 빠른 성능
👎 저장 공간이 작고 비용이 비쌈


결국 **캐시해서 사용해도 되는가?** 의 의미는 
> 반복적으로 데이터를 불러오는 경우에, 지속적으로 DBMS 혹은 서버에 요청하는 것이 아니라 Memory에 데이터를 저장하였다가 불러다 쓰는 것

**Cache hit:** 요청 데이터가 캐시에 존재해 반환
**Cache miss:** 요청 데이터가 캐시에 없어서 서버/DBMS에 요청

출처: https://mangkyu.tistory.com/69 [MangKyu's Diary]
