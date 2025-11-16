import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        Map<String, List<String>> map = new HashMap<>();
        
        for(String[] clo : clothes){
            
            map.putIfAbsent(clo[1], new ArrayList<>());
            map.get(clo[1]).add(clo[0]);
        }
        int sum = 1;
        for(String key : map.keySet()){
            sum  = sum * (map.get(key).size()+1);
            
        }
        return sum - 1;
    }
}