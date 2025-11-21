class Solution {
    public int solution(int n) {
        
        
        int answer = fibonacci(n) % 1234567 ;
        
        return answer;
    }
    
    public int fibonacci(int n ){
         if(n == 0) {
             return 0;
         } else if(n ==1){
             return 1;
         } 
        
        return fibonacci(n -1) + fibonacci(n-2);
    }
}