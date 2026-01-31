import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        // "[닉네임]님이 들어왔습니다."
        // "[닉네임]님이 나갔습니다."
        // 근데 닉네임 변경할려면?
        // 1) 나간 후 , 새로운 닉네임으로 들어가기
        // 2) 채팅방에서 닉네임으로 변경하기
        
        // 닉네임이 변경되면 기존에 채팅방에 출력되어있던 메시지의 닉네임도 전부 변경
        
        // 중복 닉네임이 있는 상황이다. 
        // Enter uid1234 Muzi -> uid 로 구분해야한다
        
        Map <String, String> userInfo = new HashMap<>(); //uid, nickname
        List<Log> logging = new ArrayList<>();
        
        for(String r : record) {
            // 레코드 한줄 읽어왔는데
            // 일단 파싱하자
            String[] line = r.split(" ");
            //line[0] -> 상태 , line[1] -> uid, line[2] -> nickname
            
            if(line[0].equals("Enter")){
                Log log = new Log(line[1], line[0]);
                userInfo.put(line[1], line[2]);
                
                logging.add(log);
            } else if(line[0].equals("Leave")) {
                Log log = new Log(line[1], line[0]);
                logging.add(log);
            } else {
                userInfo.put(line[1], line[2]);
            }
        }
        
        int size = logging.size();
        String[] answer = new String[size];
        
        for(int i = 0; i < size; i++){
            Log log = logging.get(i);
            
            String[] info = log.getInfo();
            
            if(info[1].equals("Enter")) {
                String nick = userInfo.get(info[0]);
                answer[i] = nick+"님이 들어왔습니다.";
            } else if(info[1].equals("Leave")){
                String nick = userInfo.get(info[0]);
                answer[i] = nick+"님이 나갔습니다.";
            }
        }
        
        
        
        return answer;
    }
}

class Log {
    String uid;
    String event;
    
    public Log(String uid, String state){
        this.uid = uid;
        this.event = state;
    }
    
    public String[] getInfo(){
        return new String[]{uid,event};
    }
}