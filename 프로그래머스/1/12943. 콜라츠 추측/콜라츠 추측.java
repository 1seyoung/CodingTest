class Solution {
    public int solution(int num) {
        
        if(num == 1){
            return 0;
        }
        
        long n = num;
        
        for(int i = 0; i < 500; i++){
            if(n % 2 == 0) {
                // 짝수라면
                n = n / 2;
            } else {
                n = n * 3 + 1;
            }
            
            if(n == 1){
                return i+1;
            }
        }
        
        
        
        return -1;
    }
}