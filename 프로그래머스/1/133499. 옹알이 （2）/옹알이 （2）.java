import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        int count = 0;
        
        for(String s : babbling) {
            
            String temp = s;
            String prev = "";
            boolean possible = true;
            
            while(!temp.isEmpty()){
                boolean matched = false;
                
                for(String w : words){
                    // 앞에서부터 일치해야하고 연속해서 같으면 x
                    if(temp.startsWith(w) && !w.equals(prev)){
                        // w로 시작하고 이전이랑 안똑같음
                        temp = temp.substring(w.length()); // 길이만큼 잘라서 남은거만 넣어
                        prev = w;
                        matched = true;
                        break;
                    }
                }
                
                if(!matched){ // 매칭이 안된거면
                    possible = false;
                    break;
                }
            }
            
            if(possible) count ++;
            
            
        }
        
        
        return count;
    }
}