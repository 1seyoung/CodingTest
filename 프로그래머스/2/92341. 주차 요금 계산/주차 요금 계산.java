import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Set<Integer> carNumbers = new HashSet<>(); // 차번호 아카이브
        
        Map<Integer, List<String>> recordMap= new HashMap<>(); // 차번호 , 누적 시간
        
        // 특이사항 마지막 입차 시간 이후 출차 기록이 없다면 23:59 에 나간 것으로 간주
        
        for(String record : records) {
            String[] r = record.split(" ");
            int cn = Integer.parseInt(r[1]);
            recordMap.putIfAbsent(cn, new ArrayList<>());
            recordMap.get(cn).add(r[0]);
            
            carNumbers.add(cn);
        }
        
        int idx = 0;
        int[] carNumberSort = new int[carNumbers.size()];
        for(int car : carNumbers){
            carNumberSort[idx++] = car;
        }
        
        
        Arrays.sort(carNumberSort);
        
        
        // 차 하나마다 누적 시간 계산해서 맵에 또 넣어
        Map<Integer, Integer> carWithTime = new HashMap<>();
        
        for(int car : carNumberSort) {
            List<String> carRecord = recordMap.get(car);
            if(carRecord.size() % 2 == 1){
                carRecord.add("23:59");
            }
            
            // 이제 누적 시간 계산
            // 몇쌍인가?
            
            for(int j = 0; j < carRecord.size() ; j += 2) {
                String[] enter = carRecord.get(j).split(":");
                String[] leave = carRecord.get(j+1).split(":");
                
                
                int enterHour = Integer.parseInt(enter[0]);
                int enterMin = Integer.parseInt(enter[1]);
                
                int enterTime = enterHour * 60 + enterMin;
                
                int leaveHour = Integer.parseInt(leave[0]);
                int leaveMin = Integer.parseInt(leave[1]);
                
                int leaveTime = leaveHour * 60 + leaveMin;
                
                int gap = leaveTime - enterTime;
                
                
                carWithTime.putIfAbsent(car, 0);
                carWithTime.put(car,carWithTime.get(car) + gap );
            }
        }
        
        int[] result = new int[carNumberSort.length];
        
        int idxx = 0;
        for(int car : carNumberSort) {
            int amount = 0;
            int carRecord = carWithTime.get(car);
            
            
            if(carRecord <= fees[0]) {
                // 기본 시간 이하면
                amount += fees[1];
            } else {
                // 단위시간 만큼(나눠떨어지지 않으면 +1)
                int per = 0;
                if((carRecord - fees[0]) % fees[2] !=0) {
                    per = ((carRecord - fees[0]) / fees[2]) + 1;
                }else {
                    per = ((carRecord - fees[0]) / fees[2]);
                }
                
                amount = fees[1] + per * fees[3];
            }
            
            result[idxx++] = amount;
        }
        
        
        
        return result;
        
        
    }
}