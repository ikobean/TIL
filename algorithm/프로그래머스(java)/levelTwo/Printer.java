package algorithm.levelTwo;
import java.util.*;
public class Printer {

    class OrgList{
        int idx, priority;
        public OrgList(int idx, int priority){
            this.idx = idx;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<OrgList> que = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++){
            que.add(new OrgList(i, priorities[i]));
        }
        
       int cnt = 0;
        while(!que.isEmpty()){
            OrgList orgList = que.poll();
            int temp = orgList.priority;
            boolean flag = false;
            
            for(OrgList org : que){
                if(temp < org.priority){
                    flag = true;
                }
            }
            /**
             * flag가 true인 동안(뒤에 더 큰 중요도가 있는 동안)
             * == 정렬되는 동안은 else를 타지 않음.
             * 
             * 그래서 정렬이 다 된 후 정렬 된 큐를 하나씩 poll 하면서 카운트하게 되기 때문에
             * cnt가 answer가 될 수 있는 것!!
             * 
             */
            if(flag){
                que.add(orgList);
            }else{
                cnt++;
                if(location == orgList.idx)  {
                    answer = cnt;
                    break;
                }
            }
        }
      
        return answer;
   
    }
}
