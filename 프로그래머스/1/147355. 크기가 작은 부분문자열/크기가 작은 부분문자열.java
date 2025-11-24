class Solution {
    public int solution(String t, String p) {
        int count = 0;
        int size = p.length();
        
        int n = t.length()  - p.length() + 1;        

        
        for(int i= 0; i<n;i++ ){
            String part = t.substring(i,i+size);
            
            if(part.compareTo(p)<=0){
                count +=1;
            }
        }
        
        return count;
    }
}