import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        
        Set<Character> skipSet = new HashSet<>();
        for(char c : skip.toCharArray()){
            skipSet.add(c);
        }
        
        
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray()){
            char cur = c;
            int move = index;
            
            while(move > 0){
                cur ++;
                
                if(cur > 'z'){
                    cur = 'a';
                }
                
                if(skipSet.contains(cur)){
                    continue;
                }
                
                move --;
            }
            sb.append(cur);
        }
        
        return sb.toString();
    }
}