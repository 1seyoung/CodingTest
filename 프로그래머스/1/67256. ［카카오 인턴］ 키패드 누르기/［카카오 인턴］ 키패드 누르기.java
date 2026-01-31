import java.util.*;
class Solution {
    int[] leftPosition = {3,0};
    int[] rightPosition = {3,2};
    public String solution(int[] numbers, String hand) {
         // 엄지는 상하좌우
        // 키패드 이동 한칸은 거리 1
        // 엄지 규칙
        // 상하좌우의 움직임
        
        //1 4 7 -> 왼손
        // 3 7 9 -> 오른손
        // 2 5 8 0 -> 가까운것 , 거리가 같으면 오른소잡이는 오 , 왼손잡이는 왼
        
        StringBuilder answer = new StringBuilder();
        
        //  (0,0) (0,1) (0,2)
        //  (1,0) (1,1) (1,2)
        //  (2,0) (2,1) (2,2)
        //  (3,0) (3,1) (3,2)
        
        // 시작점
        // 왼손 -> 3,0
        // 오른손 -> 3,2
        
        Set<Integer> leftNum = new HashSet<>(Arrays.asList(1,4,7));
        Set<Integer> rightNum = new HashSet<>(Arrays.asList(3,6,9));
        
        for(int num : numbers) {
            
            if(leftNum.contains(num)){
                answer.append("L");
                leftPosition = extractPosition(num);
                
            }else if(rightNum.contains(num)){
                answer.append("R");
                rightPosition = extractPosition(num);
            } else {
                
                int r = calculateDistance(rightPosition, num);
                int l = calculateDistance(leftPosition, num);
                
                if(r==l) {
                    if(hand.equals("right")) {
                        answer.append("R");
                        rightPosition = extractPosition(num);
                    } else {
                        answer.append("L");
                        leftPosition = extractPosition(num);
                    }
                } 
                if(r<l) {
                    answer.append("R");
                    rightPosition = extractPosition(num);
                }
                if(r>l) {
                    answer.append("L");
                    leftPosition = extractPosition(num);
                }
            } 
            
            
        
        }
        
        return answer.toString();
    }
    
    public int calculateDistance(int[] cur, int nextNum) {
        
        int[] next = extractPosition(nextNum);
        
        return Math.abs(cur[0] - next[0]) + Math.abs(cur[1] - next[1]); 
    }
    
    public int[] extractPosition(int num){
        // 좌표 도출
        if(num == 0) {
            return new int[]{3,1};
        }
        if(num == 1) {
            return new int[]{0,0};
        }
        if(num == 2) {
            return new int[]{0,1};
        }
        if(num == 3) {
            return new int[]{0,2};
        }
        if(num == 4) {
            return new int[]{1,0};
        }
        if(num == 5) {
            return new int[]{1,1}  ;
        }
        if(num == 6) {
            return new int[]{1,2} ;
        }
        if(num == 7) {
            return new int[]{2,0}  ;
        }
        if(num == 8) {
            return new int[]{2,1} ; 
        }
        if(num == 9) {
            return new int[]{2,2}  ;
        }
        
        
        return new int[]{};

    }
}