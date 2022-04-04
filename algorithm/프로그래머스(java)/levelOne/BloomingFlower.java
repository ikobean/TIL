package algorithm.levelOne;
import java.util.*;
/**
 * 
 * 프로그래머스 / cos pro 1급 모의고사 / 꽃피우기
 * https://programmers.co.kr/learn/courses/11132/lessons/71155
 * 
 */
public class BloomingFlower {
    public int solution(int[][] garden) {

        // 여기에 코드를 작성해주세요.
        int[] xArr = {-1, 1, 0, 0};
        int[] yArr = { 0, 0,-1, 1};
        int answer = 0;
        
    	class Flower{
            int x,y;

            public Flower(int x, int y){
                this.x = x;
                this.y = y;
            }
        }

    	//현재 꽃 핀 곳의 좌표를 넣어야함 그래야 또 가서 찾지!      
        Queue<Flower> xy = new LinkedList<>();
        
        int max = garden.length;
        for(int i = 0; i < garden.length; i++){
            for(int j = 0; j < garden.length; j++){
                // 핀 꽃의 좌표 
                if(garden[i][j] == 1){
                	xy.add(new Flower(i,j));
                }
            }
        }
  
        while(!xy.isEmpty()) {
            Flower temp = xy.poll();
            int dx = temp.x;
            int dy = temp.y;
            //사방으로 +1을 해
        	for(int k = 0; k < xArr.length; k++){
                int dx2 = dx + xArr[k];
                int dy2 = dy + yArr[k];
                //if (!(1 <= nx && nx <= n && 1 <= ny && ny <= m))
                // dx, dy 가 이거여야 하는데 이게 아니면 continue;
                //out of bound 처리
                if(!(dx2 >= 0 && dx2 < max && dy2 >= 0 && dy2 < max )){
                    continue;
                }
                if(garden[dx2][dy2] == 0){
                    int day = garden[dx][dy];
                    int next = day+1;
                    garden[dx2][dy2] = next;
                    xy.add(new Flower(dx2,dy2));      
                    answer = Math.max(answer, next-1);
                }
                                
            }

        }


        return answer;
    }
 
    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        BloomingFlower sol = new BloomingFlower();
        int[][] garden1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int ret1 = sol.solution(garden1);
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");
        
        int[][] garden2 = {{1, 1}, {1, 1}};
        int ret2 = sol.solution(garden2);
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
        
    }    
}
