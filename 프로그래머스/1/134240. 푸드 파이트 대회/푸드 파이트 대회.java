class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        //남는 음식 처리, 한명이 먹을 음식
        for(int i = 1;  i < food.length;i++){
            if(food[i] % 2 == 1){
                food[i] = food[i] - 1;
            }
            
            food[i] = food[i] / 2 ;
        }
        
        int[] foodCopy = food;
        
        
        for(int i = 1; i < food.length; i++){
            int temp = food[i];
            while(temp > 0){
                sb.append(i);
                temp --;
            }
        }
        
        StringBuilder sb2 = new StringBuilder(sb).reverse();

        sb.append(0);
        sb.append(sb2);
                
        
        return sb.toString();
    }
}