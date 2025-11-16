import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> res = new ArrayList<>();
        int cache = -1;
        for(int num : arr){
            if(num != cache){
                res.add(num);
                cache = num;
            }
        }
        
        int[] answer = new int[res.size()];
        
        for(int i = 0; i < res.size(); i++){
            answer[i] = res.get(i);
        }

        return answer;
    }
}