import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        // 몇번 문제까지?
        int n = answers.length;
        
        // 각 수포자 답안지 만들기
        
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] arr3 = new int[n];
        
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // 1번 수포자
        for(int i = 0; i < n; i++){
            int k = pattern1.length; // 패턴의 길이
            if(i == 0 ){
                arr1[i] = pattern1[0];
            } else{
                int l = i % k;
                arr1[i] = pattern1[l];
            }
        }
        
        // 2번 수포자
        for(int i = 0; i < n; i++){
            int k = pattern2.length; // 패턴의 길이
            if(i == 0 ){
                arr2[i] = pattern2[0];
            } else{
                int l = i % k;
                arr2[i] = pattern2[l];
            }
        }
        
        // 3번 수포자
        for(int i = 0; i < n; i++){
            int k = pattern3.length; // 패턴의 길이
            if(i == 0 ){
                arr3[i] = pattern3[0];
            } else{
                int l = i % k;
                arr3[i] = pattern3[l];
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        int count1  = 0;
        int count2 =0;
        int count3 = 0;
        
        
        for(int i = 0; i < n; i++){
            if(arr1[i] == answers[i]){
                count1++;
            }
            if(arr2[i] == answers[i]){
                count2++;
            }
            if(arr3[i] == answers[i]){
                count3++;
            }
        }
        
       int max =  Math.max(count1, count2);
        max = Math.max(max, count3);
        
        int[] dd = {count1, count2, count3};
        
        for(int i = 0; i < 3; i++){
            if(dd[i] == max){
                list.add(i);
            }
        }
        
        int[] an = new int[list.size()];
        
        for(int i = 0; i <list.size(); i++){
            an[i] = list.get(i)+1;
        }
        
        return an;
    }
}