import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String runner : participant){
            map.put(runner , map.getOrDefault(runner, 0 )+1);
        }
        
        for(String runner : completion ){
            map.put(runner, map.get(runner) -1);
        }
        
        
        for(String key : map.keySet()){
            if(map.get(key) != 0 ) {
                answer = key;
            }
        }
        
        
        return answer;
    }
}