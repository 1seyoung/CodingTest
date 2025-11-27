import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        // 당첨 번호 win_nums
        Set<Integer> winSet = new HashSet<>();
        for(int n : win_nums) {
            winSet.add(n);
        }
        
        boolean[] arr = new boolean[6];
        
        int possible = 0;
        int matched = 0;
        
        for(int num : lottos){
            if(num == 0) {
                possible ++;
                continue;
            } 
            
            if(winSet.contains(num)){
                matched ++;
                continue;
            }
        }
        
        
        answer[1] = getGrage(matched);
        answer[0] = getGrage(matched+possible);
        
        return answer;
    }
    
    public int getGrage(int num){
        if(num == 6) return 1;
        if(num == 5) return 2;
        if(num == 4) return 3;
        if(num == 3) return 4;
        if(num == 2) return 5;
        
        return 6;
    }
}