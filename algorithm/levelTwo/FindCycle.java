/*
* cos pro 1급 기출문제.
* 이건 아예... 외워야 될 것 같다.
* 
*/

/*

*/
class FindCycle {
	public int find(int[] parent, int u) {
		if(u == parent[u])
			return u;

		parent[u] = find(parent, parent[u]);
		return parent[u];
	}

	public boolean merge(int[] parent, int u, int v) {
		u = find(parent, u);
		v = find(parent, v);

		if(u == v)
			return true;

		parent[u] = v;
		return false;
	}

	public int solution(int n, int[][] connections) {
		int answer = 0;

		int[] parent = new int[n+1];
		for(int i = 1; i <= n; i++)
			parent[i] = i; // n = 3이면 1 2 3 4 

		for(int i = 0; i < connections.length; i++)
			if(merge(parent, connections[i][0], connections[i][1])) {
				answer = i + 1;
				break;
			}

		return answer;
	}
}


/**
 * 
 * #문제7
그래프의 노드 수와 노드 연결 순서가 주어질 때,
 몇 번째 연결에 사이클이 생기는지 알고 싶습니다.
  예를 들어, 노드가 3개이고 노드를 [[1, 2], [1, 3], [2, 3]]
   순으로 연결한다면 아래 그림과 같습니다.

* 1번째 연결

  ![스크린샷 2018-10-18 오후 3.24.04.png](https://grepp-programmers.s3.amazonaws.com/files/ybm/68aeac0c55/25583a72-6b24-4cda-b985-5a232c95460f.png)

* 2번째 연결

  ![스크린샷 2018-10-18 오후 3.25.21.png](https://grepp-programmers.s3.amazonaws.com/files/ybm/958f823cc3/2be0b0c6-98f1-4b56-a492-f7bd809e5a8e.png)

* 3번째 연결

  ![스크린샷 2018-10-18 오후 3.25.25.png](https://grepp-programmers.s3.amazonaws.com/files/ybm/ceee867a19/257b6c44-ff83-4c63-b7c3-113b32237759.png)

따라서 3번째 연결에서 사이클이 생깁니다.

그래프의 노드 수 n, 노드 연결 순서 connections가 매개변수로 주어질 때, 
몇 번째 연결에 사이클이 생기는지 return 하도록 solution 메소드를 작성하려 합니다. 빈칸을 채워 전체 코드를 완성해주세요.

---

#####매개변수 설명
그래프의 노드 수 n, 노드 연결 순서 connections가 solution 메소드의 매개변수로 주어집니다.
* 그래프의 노드 수 n은 3 이상 10 이하입니다.
* connections은 길이가 3 이상 50 이하인 배열입니다.
* connections 배열의 각 행은 [a, b]는 a번 노드와 b번 노드를 연결한다는 의미입니다.
* 항상 사이클이 생기는 경우만 주어집니다.

---

#####return 값 설명
몇 번째 연결에서 사이클이 생기는지 return 합니다.

---

#####예제

| n | connections              | return |
|---|--------------------------|--------|
| 3 | [[1, 2], [1, 3], [2, 3]] | 3      |

#####예제 설명
문제에 나온 예와 같습니다.
 * 
 */
