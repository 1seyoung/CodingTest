import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        // 원래 한대가 있네 
        // m -> 증설 기준 사람 수 , k 는 한번 생긴 서버가 
        int count = 0; // 서버 증설 횟수 
        int[] end = new int[24+k];      // 서버 종료 시점 관리 
        int n = 0; // 지금 운영 중인 서버 수 
        
        for(int i = 0 ;i < 24 ; i ++) {
            
            // 지금 시점에 종료 시켜야 하는 서버 수 계산해 n 에서 빼() 
            n = n - end[i];

            // 지금 필요한 서버 수를 일단 구해
                // 사람 수 / m -> 나머지 있으면 +1
            int curUser = players[i];
            
            int need = curUser / m;
            

            // 만약에 지금 운영 중인 서버 수가 필요한 서버 수 보다 작으면 ? (필요한 서버 수 - 지금 수) 만큼 서버 증설
            // 증설된 횟수 count 에 더하기 
            
            if(n < need) {
                int add = need - n;
                n += add;
                count += add;
                // 서버 종료 관리에 넣어 i + k 에 넣으면 될 듯함
                end[i+k] = end[i+k] + add;
            }
            
        }
        
        return count;
    }
}