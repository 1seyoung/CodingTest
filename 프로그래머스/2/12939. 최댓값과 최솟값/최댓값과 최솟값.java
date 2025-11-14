import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] parts = s.split(" ");
        
        int size = parts.length;
        
        int[] arr = new int[size];
        
        for(int i = 0;i< size; i++){
            arr[i] = Integer.parseInt(parts[i]);
        }
        
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(arr[0]);
        sb.append(" ");
        sb.append(arr[size-1]);
        
        return sb.toString();
    }
}