import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        //Stack<String> stack = new Stack<>(); 요거 말고 ArrayDeque 쓰기
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        char[] syntax = s.toCharArray();
        
        for(char c: syntax) {
            if(c == '('){
                stack.push(c);
            } else if( c == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;

    }
}