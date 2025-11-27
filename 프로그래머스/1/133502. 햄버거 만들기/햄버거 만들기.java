import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        // 아래에서 위로
        
        // 순서 : 빵(1)-야채(2)-고기(3)-빵(1)
        
        Deque<Integer> stack = new ArrayDeque<>();
        int count = 0;
        if(ingredient.length <4) {
            return count;
        } // 준비된 재료 수가 4보다 작으면 일단 0개
        
        for(int thing : ingredient) {
            stack.push(thing);
            
            if(stack.size() >= 4){
                int a = stack.pop(); 
                int b = stack.pop();
                int c = stack.pop();
                int d = stack.pop();
                
                if(d == 1 && c == 2 && b == 3 && a == 1) {
                    count +=1;
                } else {
                    stack.push(d);
                    stack.push(c);
                    stack.push(b);
                    stack.push(a);
                }
            }
            
            
        }
        
        return count;

    }
}