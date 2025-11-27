import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int xx = 0;
        for(int[] cmd : commands){
            int i = cmd[0];
            int j = cmd[1];
            int k = cmd[2];
            
            int size = j - i + 1;
            
            int[] arr = new int[size];
            
            int x = 0;
            for(int idx = i-1; idx<= j-1; idx++ ){
                arr[x] = array[idx];
                x++;
            }
            Arrays.sort(arr);
            answer[xx] = arr[k-1];
            xx++;
        }
        
        return answer;
    }
}