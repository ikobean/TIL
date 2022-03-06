## Better Way 30

#### -group by 절의 동작 원리

```
SELECT select_list
FROM table_name
WHERE search_condition
GROUP BY group_by_expression
HAVING search_condition
ORDER BY order_expression
```


* 순서 : FROM - WHERE - GROUP BY - HAVING - SELECT - ORDER BY
 
1. FROM 절 : 데이터 집합으로 만든다.
2. WHERE 절 : 1의 데이터 집합을 조건에 맞게 걸러 낸다.
3. GROUP BY 절 : 2에서 필터링한(조건에 맞는 데이터를 걸러 낸) 데이터 집합을 집계한다.
4. HAVING 절 : 3에서 집계한 데이터 집합을 다시 조건에 맞게 필터링한다.
5. SELECT 절 : 4에서 집계하고 필터링한 데이터 집합을 변환(보통 집계 함술 처리)한다.
6. ORDER BY 절 : 변환된 데이터 집합을 정렬한다.


> 대부분 DBMS는 ORDER BY 생략시 GROUP BY 절에 사용된 컬럼에서 임시로 인덱스를 생성한 후 GROUP BY 절에 있는 컬럼 순서댇로 정렬해 결과를 반환.


> ROLLUP, CUBE, GROUPING SETS 활용
