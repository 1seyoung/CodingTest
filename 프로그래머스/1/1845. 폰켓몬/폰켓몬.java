import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        // 같은 종류의 포켓몬 같은 번호
        Map<Integer,Integer> map = new HashMap<>();
        // 폰켓몬 번호, 숫자
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        
        int n = nums.length / 2;
        
        int keyCount = map.size();
        
        if(n <= keyCount){
            return n;
        } else{
            return keyCount;
        }
        
    }
}