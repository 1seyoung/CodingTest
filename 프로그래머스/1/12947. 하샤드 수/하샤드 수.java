class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        // 하샤드 수 " x 의  자리수의 합으로 x 가 나눠져야한다"
        
        int sum = 0;
        
        int target = x;
        
        while(target > 0){
            sum += target % 10;
            target = target / 10;
        }
        
        if(x % sum == 0){
            return true;
        }
        
        
        
        return false;
    }
}