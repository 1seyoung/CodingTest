
import java.util.HashMap;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        
        //실패율 : 
        //스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
        
        // 각 스테이지를 지난 숫자를 알아야함 -> 스테이지에 도달한 플레이어 수
        // 각 스테이지에 머물고 있는 사람 -> 클리어하지 못한 플레이어의 수
        
        int[] challenger = new int[N+2];
        
        for(int i = 0; i < stages.length; i++) {
            challenger[stages[i]] += 1;
        }
        
        double total = stages.length;
        
        HashMap<Integer, Double> fails = new HashMap<>();
        
        for(int i = 1; i<=N; i++) {
            if(challenger[i] == 0) {
                fails.put(i, 0.0);
            } else {
                fails.put(i, challenger[i] / total);
                total -= challenger[i];
            }
        }
        
        //값이 높은 것 부터 내림차순 정렬
        return fails.entrySet().stream().sorted((o1,o2) -> Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
        
    }
}