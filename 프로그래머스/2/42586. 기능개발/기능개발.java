import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        // progresses -> 작업의 진도가 적혀있음(100이 만점)
        // speeds -> 각 인덱스 작업 별 진행 속도
        
        // 각 기능은 앞에 있는 기능이 배포되어야 배포할 수 있다(먼저 100이되어서 배포 불가)
        
        // 각 배포마다 몇개의 기능이 배포되는지
        List<Integer> result = new ArrayList<>();
        
        int n = progresses.length; 
        
        // 각 업무가 얼마나 걸릴려나
        int[] days = new int[n];
        
        for(int i = 0; i < n; i++) {
            int remain = 100 - progresses[i];
            int day = remain / speeds[i];
            if(remain % speeds[i] != 0) {
                day++;
            }
        
            days[i] = day;
        }
        
        // 지금 일이 끝나는 시점에 뒤에 일이 끝나 있나?
        
        for(int i  = 0 ;  i < n ;) {
            // 지금 일이 끝나는 일수
            int cur = days[i];
            int count = 1;
            
            int j = i + 1;
            while (j < n && days[j] <= cur) {
                count++;
                j++;
            }
            
            i= j;

            result.add(count);
        }
        
        int answerSize = result.size();
        int[] answer = new int[answerSize];
        
        for(int i=0; i<answerSize;i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}