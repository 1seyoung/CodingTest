import java.util.*;
class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        char[] arr = my_string.toCharArray();
        
        char[] newArr = Arrays.copyOfRange(arr, arr.length-n ,arr.length );
        for(char c : newArr){
            answer+=c;
        }
        return answer;
        
    }
}