import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[] query) {
        int[] answer = {};
        
        for(int i = 0; i <query.length;i++){
            if(i % 2==0){
                // 짝수 -> 뒷부분 잘라
                arr = Arrays.copyOfRange(arr,0,query[i]+1 );
            } else{
                // 홀수 -> 앞부분 잘라
                arr = Arrays.copyOfRange(arr, query[i],arr.length);
            }
        }
        
        return arr;
    }
}