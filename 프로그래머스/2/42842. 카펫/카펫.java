import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        
        // 가로 width
        
        // 새로 height
        
        // 노란색의 개수 => (width -2) * (height -2)
        
        // 갈색의 개수는 width * height - ((width -2) * (height -2));
        
        // 노란색의 약수짝을 찾는다?
        
        // yellow의 약수 조합으로 (h-2, w-2) 후보를 만든다
        for(int h = 1; h* h <= yellow ; h++){
            if(yellow % h == 0) {
                int w = yellow / h;
                
                int H = h+2;
                int W = w +2;
                
                if(brown == (H * W - yellow)) {
                    answer[0] = W;
                    answer[1] = H;
                }
            }
        }
        
        
        return answer;
    }
}