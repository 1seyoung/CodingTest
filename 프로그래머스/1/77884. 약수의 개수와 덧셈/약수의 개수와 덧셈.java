class Solution {
    public int solution(int left, int right) {
        
        // 보통 약수는 짝수개 홀수개인것은 제곱수 인것
        int sum =0;
        
        for(int i = left; i < right +1 ; i++ ){
            int root = (int) Math.sqrt(i);
            
            if(root * root == i){
                // 홀수개면 
                sum -= i;
            } else {
                sum += i;
            }
        }
        
        return sum;
        
        
    }
}