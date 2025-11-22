class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        // a :  기준 병수(이거만큼 주면)
        // b :  마트에서 돌려주는 병수(이거만큼 돌려준다)
        // n :  내가 지금 가진 병수
        
        // 빈병 2개 -> 콜라 1병
        // 2개 미만 이면 받을 수 없음(1개면)
        
        int count = 0;
        
        while(n >= a){
            
            // 이번 턴에서 받을 병의 수
            int exchange = (n / a) *b;
            count += exchange;
            n = exchange + ( n  % a); // 받은병 + 남은병


        }
        
        return count;
    }
}