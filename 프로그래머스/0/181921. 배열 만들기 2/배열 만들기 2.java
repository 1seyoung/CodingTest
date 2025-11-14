import java.util.*;
class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = l; i<=r; i++){
            if(isZeroFive(i)){
                arr.add(i);
            }
        }
        
        if(arr.size() == 0){
            return new int[]{-1};
        }
        
        int[] answer = new int[arr.size()];
        for(int i = 0; i<arr.size(); i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
    
    public boolean isZeroFive(int n){
        for(char c : String.valueOf(n).toCharArray()){
            if (c != '0' && c != '5') return false;
        }
        return true;
    } 
}