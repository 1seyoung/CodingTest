import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        
        
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        
        // board 재조립
        
        Map<Integer, Deque<Integer>> map = new HashMap<>();
        
        for(int i = 1; i <=board[0].length; i++ ){
            map.putIfAbsent(i, new ArrayDeque<>());
        }
        
        for(int i = 0; i < board.length; i++){    
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] >0){
                    map.get(j+1).addLast(board[i][j]);
                }

            }
        }
        
        int count = 0;
        
        for(int move : moves){
            
            if(map.get(move).isEmpty() == true){
                continue;
            }
            stack.push(map.get(move).pop());
            
            if(stack.size() > 1){
                int a = stack.pop();
                int b = stack.pop();
                
                if(a==b){
                    count += 2;
                } else {
                    stack.push(b);
                    stack.push(a);
                }
            }
        }
        
        return count ;

        
    }
}