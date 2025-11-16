import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        
        // 남은 작업량 = 100 - progresses[i]
        // 걸리는 일수 = 남은 작업향 / speeds[i]
        // 만약 나머지가 존재하면 +1 일 걸림
        
        // 앞이 끝나야 뒤도 나간다.
        
        // 완료일?
        
        
        List<Integer> result = new ArrayList<>();
        int n = progresses.length;
        
        // 1. 완료 일 수 계산
        int[] days = new int[n];
        
        for(int i = 0 ; i< n; i++){
            int remain = 100 - progresses[i];
            int day = remain / speeds[i];
            if(remain % speeds[i] != 0){
                day +=1;
            }
            days[i] = day;
        }
        
        // 2. 앞 기능 기준으로 뒤 기능들을 묶기
        int current = days[0];
        int count = 1;
        
        for(int i = 1; i < n; i++){
            if(days[i] <= current ){
                count++;
            } else{
                result.add(count);
                count = 1;
                current = days[i];
            }
        }
        
        result.add(count);
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}