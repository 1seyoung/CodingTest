import java.util.*;
class Solution {
    public int solution(int n, int w, int num) {
        List<Integer> answers =  new ArrayList<>();
        int answer = 0;
        // n -> 개수, w -> 가로에 놓는 개수,num -> 꺼낼 것
                
        // num 은 어느 줄에 있을까?
        int numRow = 0;
        if(num % w == 0){
            numRow = (num / w) ;
        } else {
            numRow = (num / w) +1;
        }
        
        // numRow 가 짝수 열이다 ->
        
        while(true){
            if(numRow % 2 == 1){

                int sum = ((numRow) * w) + ((numRow) * w) +1;
                num = sum - num;

                if(num <= n){
                    answers.add(num);
                    numRow += 1;
                } else {
                    break;
                }

            } else  {
                int sum = (((numRow-1) * w) + 1) + ((numRow+1) * w) ;
                

                num = sum - num;
                if(num <= n){
                    answers.add(num);
                    numRow += 1;
                }  else{
                    break;
                }               
            }
        }

        return answers.size() +1;
    }
}