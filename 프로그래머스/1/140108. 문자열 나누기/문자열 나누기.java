class Solution {
    public int solution(String s) {
        
        int count = 0;
        int same = 0;
        int other = 0;
        char x = s.charAt(0);
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(c == x) {
                same ++;
            } else {
                other++;
            }
            
            if(other == same ){
                count ++;
                
                same = 0;
                other = 0;
                
                if(i + 1 < s.length()) {
                    x = s.charAt(i+1);
                }
            }
        
        }
        
        if(same !=0 || other !=0){
            count ++;
        }
        
        return count;
    }
}