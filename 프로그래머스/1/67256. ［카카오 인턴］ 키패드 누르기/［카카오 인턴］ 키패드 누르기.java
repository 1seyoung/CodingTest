import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        // 엄지로 눌러
        
        // 왼엄 : * -> 상하좌우(한칸단 1) // 1,4,7(가장 왼쪽 열)
        // 오엄 : * -> 상하좌우(한칸단 1) // 3,6,7(가장 오른쪽 열)
        // 가운데열 : 2,5,8,0(두 엄지 현재 키패드의 위치에서 더 가까운 엄지 사용)(같으면 오른손잡이 -> 오엄 / 반대)
        
        // numbers > 눌러야하는 것
        // hand -> 오른손잡이/왼손잡이 여부
        // 1  2  3
        // 4  5  6
        // 7  8  9
        // 10 11 12 
        int[] lIdx = {3,0};
        int[] rIdx = {3,2};
        
        StringBuilder sb = new StringBuilder();
        
        for(int num : numbers){
            if(num == 1 || num == 4 || num == 7){
                sb.append("L");
                
                lIdx = extractIdx(num);
            } else if(num == 3 || num == 6 || num == 9 ){
                sb.append("R");
                rIdx = extractIdx(num);
            }else {
                int[] target = extractIdx(num);
                
                int ld = extractDistance(target, lIdx);
                int rd = extractDistance(target, rIdx);
                
                if(ld == rd){
                    if(hand.equals("right")){
                        // 오른손잡이면
                        sb.append("R");
                        rIdx = extractIdx(num);
                    } else {
                        // 왼손잡이면
                        sb.append("L");
                        lIdx = extractIdx(num);
                    }
                } else if(ld < rd){
                    // 왼손으로
                    sb.append("L");
                    lIdx = extractIdx(num);
                } else {
                        sb.append("R");
                        rIdx = extractIdx(num);
                }
            }
        }
        
        return sb.toString();
    }
    
    public int[] extractIdx(int num){
        if(num == 0){
            int[] extract = {3, 1};
            return extract;
        }else{
                    
            int row = (num-1) / 3;
            int col = (num-1) % 3;
            int[] extract = {row, col};
            return extract;
        }

    }
    
    public int extractDistance(int[] target , int[] crr){
        return Math.abs(target[0] - crr[0]) + Math.abs(target[1] - crr[1]);
    }
}