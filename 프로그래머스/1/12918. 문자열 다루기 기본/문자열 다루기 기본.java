class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        char[] arr = s.toCharArray();
        
        if(arr.length == 4 || arr.length == 6){
            for(int i = 0; i < arr.length;i++){
                if ("0123456789".contains(String.valueOf(arr[i]))) {
                    continue;
                } else {
                    return false;
                }
            }
        } else{
            return false;
        }
        
        return true;
    }
}