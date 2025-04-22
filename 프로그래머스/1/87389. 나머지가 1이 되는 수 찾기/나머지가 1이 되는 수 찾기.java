class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int target = n - 1; // n - 1
        for (int x = 2; x <= Math.sqrt(target); x++) {
            if(target % x == 0) {
                return x;
            }
        }
        return target;
    }
}