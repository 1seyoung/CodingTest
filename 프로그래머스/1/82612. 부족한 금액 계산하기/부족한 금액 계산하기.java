class Solution {
    public long solution(int price, int money, int count) {
        // 놀이기구를 N 번째 이용하면 기존 price *N 으로 인상
        // 1번 100 2번 200 3번 300
        long sum = 0;
        for(int i = 1 ; i <= count ; i++){
            sum += price *i;
        }
        
        if(sum <=  money){
            return 0;
        } 
        
        long answer = sum - (long)money ;

        return answer;
    }
}