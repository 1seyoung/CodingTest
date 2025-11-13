class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];
        int i =0;
        for(int j = num_list.length - 1; j >=0; j--){
            answer[i++] = num_list[j];
        }
        
        return answer;
    }
}