class Solution {
    public int[] solution(int n, int m) {
        
        int x = gcd(n,m);
        int y = n * m / x;
        
        int[] answer = {x,y};
        
        return answer;
    }
    
    public int gcd(int a , int b){
        while(b!=0){
            int r = a % b;
            a = b;
            b = r;
        }
        
        return a;
    }
}