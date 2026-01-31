import java.util.*;
class Solution {
    public String solution(String new_id) {
        // 네오의 업무 : 새로 가입한 유저들이 입력한 아이디를 카카오 규칙에 맞게 수정하는 것
        
        String answer = "";
        
        if(isKakaoRule(new_id)){
            return new_id;
        }else {
            // 규칙에 맞게 수정
            
            //step 1. 대문자를 다 소문자로 치환한다.
            String ni = new_id.toLowerCase();
            
            StringBuilder st = new StringBuilder(ni);
            
            // step 2. new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 것 제거
        Set<Character> allowed = new HashSet<>(Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','-','_','.','1','2','3','4','5','6','7','8','9','0'));
            
            for(int i = 0 ; i < st.length();) {
                char c = st.charAt(i);
                
                if(!allowed.contains(c)){
                    st.deleteCharAt(i);
                } else {
                    i++; // 안지우면 늘려
                }
            }
            
            // step 3. 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
            for (int i = 0; i < st.length(); ) {
                if (st.charAt(i) == '.') {
                    if (i + 1 < st.length() && st.charAt(i + 1) == '.') {
                        st.deleteCharAt(i + 1);
                    } else {
                        i++;
                    }
                } else {
                    i++;
                }
            }
            
            //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
            
            if(st.length() > 0 && st.charAt(0) == '.') {
                st.deleteCharAt(0);
            }
            
            if(st.length() > 0 && st.charAt(st.length()-1) == '.') {
                st.deleteCharAt(st.length()-1);
            }
            
            
            //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
               
            if(st.length() == 0){
                st.append('a');
            } 



            //6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거               만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
            
            if(st.length() > 15) {
                st.setLength(15);
            }
               
            if(st.charAt(st.length()-1) == '.') {
                st.deleteCharAt(st.length()-1);
            }

            
            //7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
            
            if(st.length()==1){
                char cc = st.charAt(st.length()-1);
                st.append(cc);
                st.append(cc);
            }
               
             if(st.length()==2){
                char cc = st.charAt(st.length()-1);
                st.append(cc);
            }
            
            answer = st.toString();
        }
               
               

        
        return answer;
    }
    
    public boolean isKakaoRule(String newId){
        // 카카오 규칙
        // 1. 아이디 길이 : 3 - 15
        // 2. 알파벳 소문자, 숫자, - / . / _  만 사용 가능
        // 3. 마침표(.)는 처음과 끝에 사용할 수 없으며 연속으로 사용 불가함
        
        
        if(newId.length() < 3 || newId.length() >15) {
            return false;
        }
        
        char[] idArr = newId.toCharArray();
        
        Set<Character> allowed = new HashSet<>(Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','-','_','.','1','2','3','4','5','6','7','8','9','0'));
        
        for(char c : idArr) {
            if(!allowed.contains(c)){
                return false;
            }
        }
        
        
        
        if(idArr[0] == '.' || idArr[idArr.length -1] == '.'){
            return false;
        } 
        
        // . 연속으로 나오는것도 방지해야하는데?
        
        for(int i = 0 ; i < idArr.length ; i ++) {
            if(idArr[i] == '.') {
                if(idArr[i+1] =='.'){
                    return false;
                }
            }
        }
        
        return true;
    }
}