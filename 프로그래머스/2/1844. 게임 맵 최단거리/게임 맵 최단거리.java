import java.util.*;
class Solution {
    
    int[] dx = {0,0,1,-1}; // 상하좌우
    int[] dy = {1,-1,0,0} ; // 상하좌우
    // bfs
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        Deque<int[]> dq = new ArrayDeque<>();
        
        dq.offer(new int[]{0,0,1});
        visited[0][0] = true;
        
        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            
            // 도착지면 return
            
            if(x == n -1 && y == m - 1) {
                return dist;
            }
            
            for(int i = 0; i < 4; i ++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx <0 || ny <0 || nx >= n || ny >=m){
                    continue;
                }
                
                if(maps[nx][ny] == 0) {
                    continue;
                }
                
                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dq.offer(new int[]{nx, ny , dist+1});
                }
            }
            
        }
        
        return -1;
        
    }
}