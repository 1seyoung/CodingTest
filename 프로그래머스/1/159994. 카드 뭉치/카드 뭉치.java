import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        Deque<String> cards1Copy = new ArrayDeque<>();
        
        Deque<String> cards2Copy = new ArrayDeque<>();
        
        for(String card : cards1){
            cards1Copy.addLast(card);
        }
        
        for(String card : cards2) {
            cards2Copy.addLast(card);
        }
        
        for(String s : goal){
            if(!cards1Copy.isEmpty() && cards1Copy.peekFirst().equals(s)){
                //첫번째 카드 뭉치와 같으면
                cards1Copy.pollFirst();
                continue;
            }
            
            if(!cards2Copy.isEmpty() && cards2Copy.peekFirst().equals(s)){
                
                // 두번째 카드 뭉치와 같으면
                cards2Copy.pollFirst();
                continue;
            }
            
            return "No";
            
            
        }
        

            return "Yes";

        
        
        
    }
}