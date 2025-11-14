class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        int idx = 0;
        int n = 0;
        for(String s : seoul){
            if(s.equals("Kim")){
                n = idx;
            }
            idx ++;
        }
        
        answer = "김서방은 " + n+"에 있다";
        return answer;
    }
}