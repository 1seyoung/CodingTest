import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        Map<Character, Integer> cache = new HashMap<>();

        
        char[] arr = s.toCharArray();
        
        int[] answer = new int[arr.length];
        
        for(int i = 0; i < arr.length; i++){
            
            if(!cache.keySet().contains(arr[i])){
                cache.put(arr[i], i);
                answer[i] = -1;
            } else {
                answer[i] = i - cache.get(arr[i]);
                cache.put(arr[i], i);
            }
        }
        
        return answer;
        
    }
}