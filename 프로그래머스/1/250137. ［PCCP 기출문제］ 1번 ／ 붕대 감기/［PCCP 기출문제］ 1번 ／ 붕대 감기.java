import java.util.*;
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int t = bandage[0]; // 시전시간
        int x = bandage[1]; // 1초마다 회복되는 체력
        int y = bandage[2]; // t초만큼 붕대감기 성공하면 추가로 회복되는 체력
        
        
        int maxHealth = health;
        // 공격당하면 기술 취소
        
        // attacks 는 정렬된 상태 
        
        // 0초 공격력 -> health
        
        // 시전 누적합
        int prefixSum = 1;
        
        // 공격 map 에 담아두자
        Map<Integer, Integer> AttackMap = new HashMap<>();
        for(int[] aa : attacks){
            AttackMap.put(aa[0], aa[1]);
        }
        
        // 마지막 공격 타임
        int lastAttackTime = attacks[attacks.length -1][0];
        
        for(int i = 1 ; i <= lastAttackTime; i++ ){
            if(AttackMap.getOrDefault(i, -1) == -1){
                // 공격이 없으면요?
                health += x ;// 1초마다 더해지는 체력 회복량을 더하고
                if(health >= maxHealth){
                    health = maxHealth;
                }
                prefixSum +=1; // 누적시간도 늘려주고
                if(prefixSum == t){
                    // 만약 누적합이 시전풀차징이다?
                    health += y;
                    if(health >= maxHealth){
                    health = maxHealth;
                    }
                    prefixSum = 0;
                }
            } else {
                // 공격이 있다
                prefixSum =0 ; // 누적시간을 초기화시키고
                health -= AttackMap.get(i);
            }
            
            if(health <= 0 ){
                return -1;
            }

        }
        
        return health;
    }
}