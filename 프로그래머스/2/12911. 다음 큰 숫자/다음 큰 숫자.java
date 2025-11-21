import java.util.*;
class Solution {
    public int solution(int n) {
        int target = n;
        boolean flag = true;
        
        int count = 0;
        
        while(target > 0 ){
            if(target % 2 == 1){
                count += 1;
            }
            target = target / 2;
        }
        
        int answer = 0;
        
        while(flag){
            
            int temp = n+1;
            int oneCount = 0;
            while(temp > 0){
                if(temp % 2== 1){
                    oneCount +=1;
                }
                
                temp = temp / 2;
            }
            
            if(oneCount ==count){
                flag = false;
                answer = n+1;
            }
            
            
            
            n++;
            
        }
        
        return answer;
    }
}