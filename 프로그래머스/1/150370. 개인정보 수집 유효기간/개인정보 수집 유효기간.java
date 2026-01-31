import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        
        
        
        // 목표 : 유효기간이 지난것을 파기한다. 
        
        // 1. term -> Map 으로 만들어서 조회 편하게 하자
        
        Map<String, Integer> termMap = new HashMap<>();
        
        for(String term : terms) {
            String[] tArr = term.split(" ");
            
            termMap.put(tArr[0], Integer.parseInt(tArr[1]));
        }
        
        // 이제 privacies 한줄 한줄 보자
        // 만약에 유효기간 만료라고 판단되면 result 에 index +1을 넣자
        
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < privacies.length; i++) {
            // privacies[i]를 공백 기준으로 쪼개서 보자
            String[] privacie = privacies[i].split(" ");
            
            // privacie[0] -> 계약 날짜 , privacie[1] -> 약관
            
            //약관의 기간은?
            int period = termMap.get(privacie[1]); // month
            
            // 계약 날짜에 period 더하기
            // 계약 날짜를 . 기준으로 쪼개자
            
            String[] contractDate = privacie[0].split("\\.");
            
            // contractDate[0] -> 년 , contractDate[1] -> 월 , contractDate[2] -> 일
            
            // 지금 계약 날짜의 월은 String -> int 로 변환 필요
            int afterYear = Integer.parseInt(contractDate[0]);
            int afterMonth = Integer.parseInt(contractDate[1]) + period;
            int afterDay = Integer.parseInt(contractDate[2]) -1;
            
            if(afterDay == 0){
                afterDay = 28;
                afterMonth =afterMonth- 1;
            }
            
            
            if(afterMonth >12) {
                // 12월이 넘으면
                
                afterYear += (afterMonth - 1) / 12;
                afterMonth = (afterMonth - 1) % 12 + 1;
            } 
            
            // 계약 만료 날짜
            // 오늘이 afterDay 이후인지 체크
            String[] todayArr = today.split("\\.");

            int todayYear  = Integer.parseInt(todayArr[0]);
            int todayMonth = Integer.parseInt(todayArr[1]);
            int todayDay   = Integer.parseInt(todayArr[2]);

            int expiry =
                    afterYear * 12 * 28 +
                    afterMonth * 28 +
                    afterDay;

            int todayValue =
                    todayYear * 12 * 28 +
                    todayMonth * 28 +
                    todayDay;

            if (expiry < todayValue) {
                result.add(i + 1);
            }
            
            
        }
        
        int resultSize  = result.size();
        int[] answer = new int[resultSize];
        
        for(int i = 0; i < resultSize; i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}