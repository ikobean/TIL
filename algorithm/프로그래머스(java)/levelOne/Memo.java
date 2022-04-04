package algorithm.levelOne;
/**
 * 프로그래머스 / cos pro 1급 모의고사 / 메모장
 * https://programmers.co.kr/learn/courses/11132/lessons/71157
 * 
 * 22/03/06
 * 문제를 너무 어렵게 생각하는 경향이 있다... 연습만이 살 길!!
 * 
 */
public class Memo {
    public int solution(int K, String[] words) {
        int answer = 1;
        int temp = 0;
        
        for(int i = 0; i < words.length; i++){
            // 전에꺼 길이 + 지금 꺼 길이가 k보다 크면 초기화
            if(temp + words[i].length() > K){
                temp = 0;
                answer++;
            }
            temp += words[i].length() + 1;
        }
  
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Memo sol = new Memo();
        int K = 10;
        String[] words = {new String("nice"), new String("happy"), new String("hello"), new String("world"), new String("hi")};
        int ret = sol.solution(K, words);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소의 반환 값은 " + ret + " 입니다.");
    }
}