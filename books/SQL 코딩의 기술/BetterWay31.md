## Better Way 31

#### -group by 절은 간단하게 만들자

####      



> BEFORE
```
SELECT   c.MEM_ID
       , c.MEM_FIRST_NAME
       , c.MEM_LAST_NAME
       , C.MEM_CITY
       , MAX(o.ODR_DATE)
       , COUNT(o.ODR_NUM
       , SUM(o.ODR_TOT)
  FROM CUSTOMERS AS c
  LEFT OUTER JOIN ORDERS AS o
    ON C.MEM_ID = o.MEM_ID
GROUP BY c.MEM_ID
       , c.MEM_FIRST_NAME
       , c.MEM_LAST_NAME
       , d.MEM_CITY
```



> AFTER
```
SELECT   c.MEM_ID
       , c.MEM_FIRST_NAME
       , c.MEM_LAST_NAME
       , C.MEM_CITY
       , o.ODR_DATE
       , o.ODR_NUM
       , o.ODR_TOT
  FROM CUSTOMERS AS c
  LEFT OUTER JOIN (
      SELECT t.MEM_ID
           , MAX(t.ODR_DATE) AS ODR_DATE
           , COUNT(t.ODR_NUM) AS ODR_NUM
           , SUM(t.ODR_TOT) AS ODR_TOT
        FROM ORDERS AS t
        GROUP BY t.MEM_ID
  ) AS o
  ON c.MEM_ID = o.MEM_ID
```



* GROUP BY 절에 컬럼을 과도하게 기술하면 쿼리의 성능에 악영향을 미칠 뿐만 아니라, 읽고 이해하고 재작성하기가 어렵다.
* 집계와 세부 정보 조회 두 가지 목적을 달성해야 하는 쿼리를 작성할 때는 먼저 서브쿼리에서 모든 집계를 수행한 후 세부 데이터를 담은 테이블과 조인해 해당 정보를 가져온다.
* 더 좋은 방법 : BETTER WAY 42, 가능하면 서브쿼리 대신공통 테이블 표현식을 사용하자 

