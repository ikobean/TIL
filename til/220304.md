## **Clustered Index**

- 지정된 컬럼에 대해 물리적으로 데이터 재배열
- 데이터 삽입, 수정, 삭제시 테이블 데이터 정렬
- index page : key + 데이터 페이지 번호
- 테이블 당 한 개씩만 가능
- 루트페이지(), 리프페이지(데이터 그 자체)
- 검색 속도가 빠름
- 입력, 수정, 삭제 속도는 느림

## **Non-Clustered Index**

- 물리적 변경 없이 지정 컬럼에 인덱스를 만듦
- 검색 속도는 느림
- 입력, 수정, 삭제는 빠름
- 여러개 존재 가능
- 데이터 페이지 + 인덱스 페이지(key + RID(포인터))

mssql key 

클러스터 인덱스는 테이터에 바로 접근이 가능하다. 리프노드가 데이터 페이지에 있기 때문이다

넌클러스터 인덱스는 데이터를 가져오기위해서는 데이터 페이지까지 찾아서 데이터를 가져와야하는데, 이때 RID를 참조해서, 데이터를 LOOK UP해오는 과정을 RID LOOKUP이라한다.

출처:[https://nive.tistory.com/186](https://nive.tistory.com/186) [기록의 발자취]

MSSQL STUDIO 에서 CTRL+L 실행 계획 인데

여기서 **KEY LOOKUP** 이 비용 37% 로 가장 높았음.

얘를 오른쪽 마우스 클릭하고 M을 누르면 **누락된 인덱스 세부정보**

인덱스 생성 SQL 문이 나옴.

```sql
USE [DNMMAIN]
GO
CREATE
CREATE NONCLUSTERED INDEX [<NAME off Missing Index, sysname,>]
ON [dbo].[TB_PY_D_ADD_CST_ORR_CXR_MAPPING] ([ORR_DT], [ORR_NO], [DEL_YN])
INCLUDE ([ORR_DTL_SQNO], [ADD_CST_NO])
GO
```

SELECT 문 앞에 

— 컴파일 시간 및 실행 시간

SET STATISTICS TIME ON;

— 각 구문의 IO 실행 결과

SET STATISTICS IO ON;

- **검색 수** : 테이블 에서 스캔 또는 탐색이 시작된 횟수 입니다. 각 테이블을 최대 한 번만 스캔해야 합니다.
- **논리적 읽기 수** : 메모리 내 캐시(버퍼 풀)에서 행을 읽은 데이터 페이지 수입니다.
- **물리적 읽기 수** : 데이터가 디스크로부터 버퍼풀에 전송된 페이지 수입니다. 데이터 전송이 완료 될 때까지 블록 또는 대기가 발생합니다.
- **미리 읽기 수** : 비동기적으로 디스크로부터 데이터를 읽어 버퍼풀에 넣는 페이지 수입니다.
- **LOB 논리적 읽기 수** : LOB 데이터를 읽은 페이지 수입니다.
- **LOB 미리 읽기 수** : LOB 데이터를 읽은 페이지 수입니다.

[https://olait.tistory.com/](https://olait.tistory.com/)

참고 ::

공식문서

[https://docs.microsoft.com/ko-kr/sql/relational-databases/performance/execution-plans?view=sql-server-ver15](https://docs.microsoft.com/ko-kr/sql/relational-databases/performance/execution-plans?view=sql-server-ver15)

블로그

[https://codepathfinder.com/m/entry/MSSQL-시간-오래-걸리는-쿼리-성능-분석하는-방법?category=980861](https://codepathfinder.com/m/entry/MSSQL-%EC%8B%9C%EA%B0%84-%EC%98%A4%EB%9E%98-%EA%B1%B8%EB%A6%AC%EB%8A%94-%EC%BF%BC%EB%A6%AC-%EC%84%B1%EB%8A%A5-%EB%B6%84%EC%84%9D%ED%95%98%EB%8A%94-%EB%B0%A9%EB%B2%95?category=980861)Blo