class Solution {
    public int[] solution(int[] num_list) {
        int n = num_list.length;
        int[] answer = new int[n+1];
        int i =0;
        for(int x : num_list){
            answer[i++] = x;
        }
        
        if(num_list[n-1]<= num_list[n-2]){
            answer[n] = num_list[n-1] *2;
        } else{
            answer[n] = num_list[n-1] - num_list[n-2];
        }
        
        return answer;
    }
}