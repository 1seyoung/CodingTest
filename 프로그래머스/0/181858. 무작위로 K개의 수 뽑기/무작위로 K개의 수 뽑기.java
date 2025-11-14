import java.util.*;
class Solution {
    public int[] solution(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        
        for(int num : arr){
            if(!list.contains(num)){
                list.add(num);
            }
        }
        
        int n = list.size();
        int[] answer = new int[k];
        Arrays.fill(answer, -1);
        
        int limit = Math.min(n,k);
        
        for(int i = 0; i <limit; i++ ){
            answer[i] = list.get(i);
        }
        return answer;
    }
}