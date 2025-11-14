class Solution {
    public String solution(String s) {
        String answer = "";
        // JadenCase -> 첫문자만 대문자, 나머지 소문자
        char[] arr = s.toCharArray();
        
        boolean change = false;
        
        for(int i = 0; i < arr.length ; i++){
            if(i ==0){
                arr[i] = Character.toUpperCase(arr[i]);
            } else if(arr[i] == ' '){
                change = true;
            } else if(change) {
                change = false;
                arr[i] = Character.toUpperCase(arr[i]);
            } else if(!change){
                arr[i] = Character.toLowerCase(arr[i]);
            }
            
        }
        
        
        
        StringBuilder sb = new StringBuilder();
        
        for(char c : arr){
            sb.append(c);
        }
        
        return sb.toString();
    }
}