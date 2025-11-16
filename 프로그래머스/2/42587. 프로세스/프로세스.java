import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Deque<int[]> q = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙
        
        for(int i = 0; i < priorities.length; i++){
            q.add(new int[]{i, priorities[i]});
            pq.add(priorities[i]);
        }
        
        int count = 0;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int idx = cur[0];
            int pr = cur[1];
            
            if(pr == pq.peek()){
                pq.poll();
                count++;
                
                if(idx == location){
                    return count;
                }
            } else {
                q.add(cur);
            }
        }
        
        return -1;
    }
}