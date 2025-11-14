class Solution {
    public long solution(int n) {
        long answer = 0;
        
        if(n == 1) {
            return 1;
        }
        
        int[] dp = new int[n+1];
        
        dp[1] =1 ;
        dp[2] =2 ;
        
        // n칸까지 오는 방법은 n-1 칸에서 1칸 뛰어온 경우 + n-2 칸에서 2칸 뛰어온 경우
        
        for(int i = 3; i <= n;i++){
            dp[i] = (dp[i-1]+dp[i-2] )%1234567;
        }
        
        return dp[n];
    }
}