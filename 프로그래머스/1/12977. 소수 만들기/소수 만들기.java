class Solution {
    public int solution(int[] nums) {
        int n = nums.length;
        
        int count = 0;
        
        for(int i = 0; i < n-2; i++ ){
            for( int j = i +1; j < n-1; j++){
                for(int k = j+1; k < n; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    
                    if(isTarget(sum)){
                        count += 1;
                    }
                }
            }
        }
        
        return count ;
    }
    
    public boolean isTarget(int n){
        

        
        for(int i = 2; i * i  <=n; i++){
            if(n % i == 0){
                return false;
            }
        }
        
        return true;
    }
}