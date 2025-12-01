import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();
        long sum1 = 0;
        long sum2 = 0;
        
        for(int n : queue1) {
            q1.addLast(n);
            sum1+=n;
        }
        for(int n : queue2) {
            q2.addLast(n);
            sum2+=n;
        }
        
        long sum = sum1 + sum2;
        long target = sum / 2;
        
        int count = 0;
        
        int limit = queue1.length * 3;
        
        while(sum1 != target && count <= limit) {
            if(sum1 > target) {
                int n = q1.poll();
                sum1 -= n;
                
                q2.addLast(n);
                sum2 += n;
            } else {
                int n = q2.poll();
                sum2 -= n;
                
                q1.addLast(n);
                sum1 += n;      
            }
            
            count ++;
        }
        
        if(count > limit){
            return -1;
        }
        
        return count;
    }
}