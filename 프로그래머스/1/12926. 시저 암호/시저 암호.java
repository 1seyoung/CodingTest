class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        
        for(char c: s.toCharArray()){
            if(c == ' '){
                sb.append(' ');
                continue;
            } 
            
            if(c >= 'A' && c<='Z'){
                char shift = (char) (((c-'A' +n) %26) + 'A');
                sb.append(shift);
            } else if (c >= 'a' && c <= 'z'){
                char shift = (char) (((c-'a'+n) % 26) +'a');
                sb.append(shift);
                
            }
        }
        return sb.toString();
    }
}