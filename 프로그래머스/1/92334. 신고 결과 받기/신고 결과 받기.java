import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        
        // 유저는 한 번에 한명 신고 -> 횟수에 제한은 없음, 한 유저를 여러번 신고할 수 있음(그러나 1회체크)
        
        // k 이상 신고된 유저는 게시판 이용 정지
        
        Map<String, Set<String>> reportMap = new HashMap<>();
        
        for(String id : id_list){
            reportMap.putIfAbsent(id,new HashSet<>());
        }
        
        for(String str : report){
            String[] contents = str.split(" ");
            
            String give = contents[0];
            String take = contents[1];
                        
            reportMap.get(take).add(give);
        }
        
        int idx = 0;
        
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> result = new HashMap<>();
        for(String id : id_list){
            result.putIfAbsent(id,0);
        }
        for(String id : id_list){

            int num = reportMap.get(id).size();
            
            if(num >= k){
                for(String name : reportMap.get(id)){
                    result.put(name,result.get(name) +1 );
                }
            }

        
            idx ++;
        }
        
        int idxx = 0;
        for(String id : id_list){
            answer[idxx] = result.get(id);
            idxx ++;
        }
        
        return answer;
    }
}