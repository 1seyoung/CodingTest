class Solution {
    public String solution(int a, int b) {
        // 1월 31일
        // 2월 28일
        // 3월 31일
        // 4월 30일/
        // 5월 31일/
        // 6월 30일/
        // 7월 31일/
        // 8월 31일/
        // 9월 30일
        // 10월 31일
        // 11월 30일
        // 12월 31일
        int[] months = {31,29,31, 30, 31,30,31,31,30,31,30,31};
        
        // 일단 몇일이 지났나를 체크하기
        int days = 0;
        
        
        for(int i = 0; i < a-1; i++){
            days += months[i];
        }
        
        days += (b - 1);
        // 이건 몇주가 지낫을까

        
        // 나머지에 따라 요일이 정해진다 0 - 화 , 1 - 수, 2- 목, 3-금, 4-토, 5-일, 6-월
        
        if(days % 7  == 4){
            return "TUE";
        } 
        
        if(days % 7  == 5){
            return "WED";
        } 
        
        if(days % 7  == 6){
            return "THU";
        } 
        
        if(days % 7  == 0){
            return "FRI";
        } 

        if(days % 7  == 1){
            return "SAT";
        } 
        
        if(days % 7  == 2){
            return "SUN";
        }
        
        if(days % 7  == 3){
            return "MON";
        }
        
        return "";
        
    }
}