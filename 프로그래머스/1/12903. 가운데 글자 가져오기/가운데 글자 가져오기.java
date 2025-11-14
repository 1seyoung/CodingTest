import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        int size = arr.length;
        int idx = 0;
        if(size % 2 == 1){
            // 짝수
            idx = size / 2 ;
            sb.append(arr[idx]);
            
        } else {
            // 홀수
            idx = size / 2;
            sb.append(arr[idx - 1]);
            sb.append(arr[idx]);
                
        }
        
        return sb.toString();
    }
}