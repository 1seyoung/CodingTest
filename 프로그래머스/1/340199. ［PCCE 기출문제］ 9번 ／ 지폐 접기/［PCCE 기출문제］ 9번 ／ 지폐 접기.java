class Solution {
    public int solution(int[] wallet, int[] bill) {
        int count =0;
        
        // 구하는 것 : 지폐 최소 몇번 접을까?
        
        int ww = wallet[0];
        int wh = wallet[1];
        
        int bw = bill[0];
        int bh = bill[1];
        
        
        // 지폐를 접을 때는 항상 길이가 긴쪽을 반으로 접는다
        // 소수점 이하는 버린다 -> 몫만
        // 90도 돌려서 넣어지면 넣는다
        
        boolean isCan = false;
        
        while(!isCan){
            if((bw <= ww && bh <=wh) || (bw <= wh && bh <= ww)){
                // 들어가는 조건
                isCan = true;
                break;
            } else {
                // 긴쪽을 접어야함
                if(bw <= bh){
                    bh = bh /2;
                } else {
                    bw = bw/2;
                }
                
                count ++;
            }
        }
        
        
        
        
        
        return count;
    }
}