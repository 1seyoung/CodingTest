import java.util.*;
class Solution {
    private int result = 0;
    public int solution(int[] numbers, int target) {

        /**
        n개의 음이 아닌 정수
        목표 : 순서 바꾸기 x 더하거나 빼서 타겟 숫자를 만든다
        
        모든 경우의 수를 탐색 -> 완탐 -> 항상 dfs(끝까지 가봐야하기 떄문에)
        **/
        dfs(numbers, target, 0,0);
          
        return result;
    }
    
    private void dfs(int[] numbers, int target, int index, int sum){
        // 종료 조건
        if(index == numbers.length) {
            if(sum == target) {
                result ++;
            }
            
            return;
        }        

        // 현재 숫자를 더하거나
        dfs(numbers, target, index + 1, sum + numbers[index]);
        // 현재 숫자를 빼거나 
        dfs(numbers, target, index+1, sum -numbers[index]);
    }
}