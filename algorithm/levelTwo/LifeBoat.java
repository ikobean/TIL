package algorithm.levelTwo;
import java.util.*;
/**
 * 프로그래머스 구명보트
 * https://programmers.co.kr/learn/courses/30/lessons/42885
 * 
 * 나는 언제쯤 다른 사람 코드를 안보고 풀 수 있을까...
 */
class LifeBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int min = 0;
        // i >= min 인 이유 : 뒤에서부터 와서 최소값이랑 만날 때를 대비
        for(int i = people.length-1; i >= min; i--){
            if(people[i] + people[min] > limit){
                answer++;  
            // 최소 + 최대 합이 같거나 작은 경우
            }else{
                answer++;
                //한 배 태운 후에 최소 값을 변경
                min++;
            }
        }
        return answer;
    }
}