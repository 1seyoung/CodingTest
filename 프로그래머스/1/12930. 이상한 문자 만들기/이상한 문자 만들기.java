class Solution {
    public String solution(String s) {
        String answer = "";
        
        char[] arr = s.toCharArray();
        
        int idx = 0;
        
        StringBuilder sb = new StringBuilder();
        
        for(char c :  arr){
            if(c == ' '){
                idx = 0;
                sb.append(' ');
                continue;
            }
            
            if(idx == 1){
                char lower = Character.toLowerCase(c);
                sb.append(lower);
                idx = 0;
            } else {
                char upper = Character.toUpperCase(c);
                sb.append(upper);
                idx = 1; 
            }
        }
        
        return sb.toString();
    }
}