import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        //Stack<String> stack = new Stack<>(); 요거 말고 ArrayDeque 쓰기
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        char[] a = s.toCharArray();
        
        for(char c:a) {
            if (c == '(') {
                stack.push(c);
            } else {
                if(stack.isEmpty() || stack.pop() == c) {
                    return false;
                }
            }
        }
        
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}