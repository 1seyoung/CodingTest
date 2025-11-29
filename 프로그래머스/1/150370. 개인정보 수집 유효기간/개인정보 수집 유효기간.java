import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        String[] todayArr = today.split("\\."); // 0 - > 년, 1 -> 월, 2 -> 일
        // 오늘 날짜 ( 모든 달의 날짜는 28일이다)
        
        // term -> 약관 종류에 다른 유효 기간
        Map<String, Integer> t = new HashMap<>();
        for(String term : terms){
            String[] arr = term.split(" ");
            t.put(arr[0], Integer.parseInt(arr[1]));
        }
        
        // privacies -> 언제 결제했고 어떤 약관이었는지
        
        int idx = 1;
        
        for(String privacy : privacies ) {
            String[] arr = privacy.split(" ");
            int termMonth = t.get(arr[1]); // 그 약관이 몇개월짜리인지 정보 가져온 것
            
            String[] dayArr = arr[0].split("\\."); 
            
            // 계약 날짜 + month
            
            int y = Integer.parseInt(dayArr[0]);
            int m = Integer.parseInt(dayArr[1]);
            int d = Integer.parseInt(dayArr[2]);
            
            m += termMonth;
            
            if(m > 12) {
                y+= (m-1) /12;
                m = (m-1) % 12 + 1;
            }
            
            d -= 1;
            if(d == 0) {
                d = 28;
                m -= 1;
                if(m == 0){
                    m = 12;
                    y -=1;
                }
            }
                
            String[] deadline = {
                String.valueOf(y),
                String.valueOf(m),
                String.valueOf(d)
            };
            
            if(getDays(deadline) < getDays(todayArr)){
                answer.add(idx);
            }
            

            idx ++;
        }
        
        int[] ddd = new int[answer.size()];
        for(int i = 0; i <answer.size();i++ ){
            ddd[i] = answer.get(i);
        }
        
        return ddd;
        
    }
    
    public int getDays(String[] arr){
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);
        
        return year *12 * 28 + month * 28 + day;
    }
}