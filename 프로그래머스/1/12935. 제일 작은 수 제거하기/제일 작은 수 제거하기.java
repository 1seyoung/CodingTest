import java.util.*;
class Solution {
    public int[] solution(int[] arr) {

        
        int minNum = Integer.MAX_VALUE;
        int minIdx = -1;
        
        if(arr.length ==0){
            return new int[]{-1};
        }
        
        for(int i = 0; i< arr.length; i++){
            if(arr[i]< minNum){
                minNum = arr[i];
                minIdx = i;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        int[] answer = new int[arr.length-1];
        
        for( int i = 0; i < arr.length;i++){
            if(i != minIdx){
                list.add(arr[i]);
            }
        }
        
        for(int i = 0 ; i < arr.length-1;i++){
            answer[i] = list.get(i);
        }
        
        if(answer.length ==0){
            return new int[]{-1};
        }
        
        return answer;
    }
}