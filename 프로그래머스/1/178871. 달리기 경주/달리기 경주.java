import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        // 이름과 현재 순위
        Map<String, Integer> rankMap = new HashMap<>();
        
        // 처음 세팅
        for(int i = 0; i < players.length; i++) {
            rankMap.put(players[i],i);
        }
        
        // 불릴때마다 바꾸기
        for(String call : callings) {
            // 불리면 앞에 선수를 추월 한 것
            // 지금 불린 선수의 순위는?
            int currentRank = rankMap.get(call);
            
            
            String frontPlayer = players[currentRank -1];
            players[currentRank -1] = call;
            players[currentRank] = frontPlayer;
            
            rankMap.put(call, currentRank -1);
            rankMap.put(frontPlayer, currentRank);
            
        }
        
        return players;
    }
}