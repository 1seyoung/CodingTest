class Solution {
    public int solution(String[][] board, int h, int w) {
        int count = 0;
        
        String color = board[h][w];
        
        int[] dh = {-1, 1, 0, 0}; // 상하좌우
        
        int[] dw = {0, 0, -1,1};
        
        
        for(int i = 0; i < 4; i++){
            int x = h + dh[i];
            int y = w + dw[i];
            
            if(x < 0 || y < 0 || x >= board.length || y >= board[0].length){
                // 경계값 처리
                continue;
            } 
            
            if(board[x][y].equals(color)){
                count +=1;
            }
        }
        

        return count;
    }
}