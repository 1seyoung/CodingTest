import java.util.LinkedList;
import java.util.Queue;


class Solution {
    public int[] solution(long n) {
        
        //1. 방법 숫자를 문자열로 해서 길이 구해
        //2. 10으로 나눠서 

        // 숫자를 문자열로 변환하여 길이 계산
        String numStr = String.valueOf(n);
        int size = numStr.length();
        int[] answer = new int[size];
            
            
        for (int i = 0; i < size; i++) {
            answer[i] = (int) (n % 10); // 마지막 자릿수 추출
            n /= 10; // 숫자를 한 자리 줄임
        }

        return answer;
    }
}