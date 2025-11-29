import java.util.*;
class Solution {
    public int[] solution(String s) {
        List<Integer> list = new ArrayList<>();
        
        
        int zeroCount = 0;
        int count = 0;
        while(!s.equals("1")){
           count ++;
            // 0 개수 세자
            for(char c : s.toCharArray()){
                if(c == '0'){
                    zeroCount ++;
                }
            }
            
            list.add(count);
            
            s = s.replace("0", "");
            
            int c = s.length();
            
            s = Integer.toBinaryString(c);
            
        }
        
        int[] answer = {count,zeroCount};
        return answer;
    }
}