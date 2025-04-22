class Solution {
    boolean solution(String s) {
        boolean answer = true;

        s = s.toUpperCase(); 
        String[] parts = s.split(""); 
        
        int pcount = 0;
        int ycount = 0;
        
        for(int i = 0; i < s.length();i++) {
            if (parts[i].equals("P")) {
                pcount +=1;
                
            }
            if (parts[i].equals("Y")) {
                ycount +=1;
            }
        }
        
        
        if (pcount == ycount) {
            return true;
        } else {
            return false;
        }
    }
}