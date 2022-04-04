package algorithm.levelTwo;
import java.util.*;
/**
 * 프로그래머스 기능개발
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 */
/**
 * 처음에는 거꾸로 생각했다. 그냥 두 배열의 원소를 곱해서 뒤에 쪽이 더 크면 cnt ++ 해주는 걸로. 근데
 * 그렇게 하고 poll을 하니까 비교가 불가능함;; 남은 일수를 계산한 뒤에
 * 앞에꺼랑 비교해야 제대로 로직이 돌아간다.
 */
public class FunctionDev {
    
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int cnt = 0;
        Queue<Integer> que = new LinkedList<>();
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i < progresses.length; i++){
            // 걸리는 날짜
            // Math.ceil() 리턴 타입이 double 이라 int 타입으로 그냥 계산해주면 2가 나와서 강제 형변환을 해줘야한다.
            que.add((int)Math.ceil((double)(100 - progresses[i])/speeds[i]));
            System.out.println(que);
        }
        
       
        while(!que.isEmpty()){
            int top = que.poll();
            cnt = 1;
            while(!que.isEmpty() && top >= que.peek()){
                cnt++;
                que.poll();
            }
            list.add(cnt);
        }
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }

}
