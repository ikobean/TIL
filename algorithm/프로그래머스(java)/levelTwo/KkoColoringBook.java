package algorithm.levelTwo;
import java.util.*;

class KkoColoringBook {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        Queue<Location> loc = new LinkedList<>();
        for(int i = 0; i < picture.length; i++){
            for(int j = 0; j < picture[0].length; j++){
                if(picture[i][j] > 0){
                    loc.add(new Location(i,j));
                }
            }
        }
        
        while((!loc.isEmpty())){
            Location cur = loc.poll();
            int cx = cur.x;
            int cy = cur.y;
            int color = picture[cx][cy];
            int cnt = 0;
            for(int k = 0; k < 4; k++){
                int toX = cx + dx[k];
                int toY = cy + dy[k];
                //out of bound 처리
                if(!(toX >= 0 && toX < m && toY >= 0 && toY < n)) continue;

                if(color > 0 && picture[cx][cy] == color){
                    picture[cx][cy] = -1;
                    picture[toX][toY] = -1;
                    cnt++;
                    maxSizeOfOneArea = Math.max(cnt, maxSizeOfOneArea);
                    
                }else if(color > 0 && picture[toX][toY] != color){
                    color = picture[toX][toY];
                    numberOfArea++;
                }
            }
            
         
        }

        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}

class Location {
    int x, y;
    public Location(int x,int y){
        this.x = x;
        this.y = y;
    }
    
    public static void main(String[] args) {
        KkoColoringBook sol = new KkoColoringBook();
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        int[] ret = sol.solution(m, n, picture);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소의 반환 값은 " + ret + " 입니다.");
    }
}