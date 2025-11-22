import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        
        String[] map = new String[n];
        
        for(int i = 0; i < n ; i++){
            String s1 = Integer.toBinaryString(arr1[i]);
            String s2 = Integer.toBinaryString(arr2[i]);
            
            if(s1.length() < n){
                int temp = n -s1.length();
                StringBuilder ss = new StringBuilder();
                for(int k = 0; k < temp ; k++){
                    ss.append(0);
                }
                StringBuilder sss = new StringBuilder(s1); 
                ss.append(sss);
                
                s1 = ss.toString();
                
            }
            if(s2.length() < n){
                int temp = n -s2.length();
                StringBuilder ss = new StringBuilder();
                for(int k = 0; k < temp ; k++){
                    ss.append(0);
                }
                StringBuilder sss = new StringBuilder(s2); 
                ss.append(sss);
                s2 = ss.toString();
            }
            
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();
            
            StringBuilder sb = new StringBuilder();
            
            for(int j = 0; j < n; j++){
                if( c1[j] == '0' && c2[j] =='0'){
                    sb.append(' ');
                }
                
                if(c1[j] == '1' || c2[j] == '1'){
                    sb.append('#');
                }
            }
            
            map[i] = sb.toString();
        }

        
        return map;
    }
}