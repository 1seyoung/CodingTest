class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        // n 미터 벽 
        
        // 구역을 n 개로 나눠 왼쪽부터 1-n
        
        // 벽에 페인트를 칠하는 롤러 길이 m미터
        
        // 꼭 칠해야하는 구간 section
        
        // 구해야하는 것 : 최소 칠해야하는 횟수
        
        int count = 0;
        
        // 체크해야하는 것 벽에 다 칠해졌나?
        
        boolean[] wall = new boolean[n];
        
        for(int sectionNum : section){
            wall[sectionNum -1] = true;
        }
        
        for(int i = 0; i < n; i++){
            if(wall[i] == true){
                // m 만큼 칠해
                
                for(int j = 0; j < m; j++){
                    if(i+j < n){
                        wall[i+j] = false;
                    }
                }
                count += 1;
            }
        }
        
        
        
        return count;
    }
}