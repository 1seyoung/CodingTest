class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        double sum = 0;
        double aver = 0;
        for(int i:arr){
            sum += i;
        }
        aver = sum / arr.length;
        return aver;
    }
}