import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        // “각 문자별로 필요한 최소 키 입력 횟수” 
       
        Map<Character, Integer> map = new HashMap<>();
        
        for(String s : keymap) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int idx = i + 1;
                
                map.put(c, Math.min(map.getOrDefault(c,Integer.MAX_VALUE), idx));
                
            }
        }
                  
        int idx = 0;  
        for(String t : targets){

            for(char c : t.toCharArray()) {
                if(map.getOrDefault(c, -1) == -1){
                    answer[idx] = -1;
                    break;
                } else {
                     answer[idx] = answer[idx] + map.get(c);
                }
            }
            idx ++;
        }

        
        
        return answer;
    }
}