import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        
        // 유저 설문 결과 저장할 map 생성
        Map<Character, Integer> map = new HashMap<>();
        
        char[] temp = {'R','T','C','F','J','M','A','N'} ;
        
        for(char c : temp) {
            map.put(c, 0);
        }
        
        for(int i = 0; i < survey.length; i ++) {
            char disagree = survey[i].charAt(0);
            char agree = survey[i].charAt(1);
            
            // 매우 비동의(1) / 비동의(2) / 약간 비동의(3) / 모르겠음(4) / 약간 동의(5) / 동의(6)/ 매우 동의(7)
            
            if(choices[i] == 1) {
                map.put(disagree,map.get(disagree) +3 );
            }  else if(choices[i] == 2) {
                map.put(disagree,map.get(disagree) + 2);
            } else if(choices[i] == 3) {
                map.put(disagree,map.get(disagree) +1 );
            } else if(choices[i] == 5) {
                map.put(agree,map.get(agree) + 1);
            } else if(choices[i] == 6) {
                map.put(agree,map.get(agree) + 2);
            } else if(choices[i] == 7) {
                map.put(agree,map.get(agree) + 3);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        // 1번 지표  RT
        if(map.get('R') > map.get('T')){
            sb.append("R");
        } else if(map.get('R') < map.get('T')){
            sb.append("T");
        } else {
            sb.append("R");
        }
        
        // 2번 지표 CF
        if(map.get('C') > map.get('F')){
            sb.append("C");
        } else if(map.get('C') < map.get('F')){
            sb.append("F");
        } else {
            sb.append("C");
        }
        
        // 3번 지표 JM
        if(map.get('J') > map.get('M')){
            sb.append("J");
        } else if(map.get('J') < map.get('M')){
            sb.append("M");
        } else {
            sb.append("J");
        }
        
        // 4번 지표 AN
        if(map.get('A') > map.get('N')){
            sb.append("A");
        } else if(map.get('A') < map.get('N')){
            sb.append("N");
        } else {
            sb.append("A");
        }
        
        return sb.toString();
    }
}