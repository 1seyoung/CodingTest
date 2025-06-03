class Solution {
    int solution(int[][] land) {
        int answer = 0;

        /**
        
        땅따먹기 N행 4열 / 모든 칸 점수 / 1행부터 땅 밟으면서 한 행씩 내려옴 
        / 한 행에서 한 칸만 밟아야함 / 같은 열 연속 밟기 금지
        
        (마지막 행동)마지막 행을 밟을 때 4개 중에 하나.
        (이 전 행동) 2,3,4 중에 하나 밟아야한다. 
        
        밟은 것의 점수르 합쳐서 최고점
        
        **/
        
        int row = land.length;
        int col = 4;
        
        int[][] dp = new int[row][4];
        
        // 점화식 dp[n][0] = Math.max(dp[n-1][1], Math.max(dp[n-1][2], dp[n-1][2]))  + land[n][0]
        //land[][] + max(dp[i-1][])
        
        // 초기화
        for(int i = 0;  i <4 ; i++){
            dp[0][i] = land[0][i];
        }
        
        // 이전 행에서 같은 열을 제외한 열 중 최대값 더하기
        
        for(int i = 1; i < row ; i++) {
            dp[i][0] = land[i][0] + Math.max(dp[i-1][1], Math.max(dp[i-1][2], dp[i-1][3] ));
            dp[i][1] = land[i][1] + Math.max(dp[i-1][0], Math.max(dp[i-1][2], dp[i-1][3] ));
            dp[i][2] = land[i][2] + Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][3] ));
            dp[i][3] = land[i][3] + Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2] ));  
        }
        
        int max = 0;
        for(int i = 0; i < 4; i++){
            max = Math.max(max, dp[row-1][i]);
        }
        
        return max;
    }
}