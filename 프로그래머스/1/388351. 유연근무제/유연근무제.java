 import java.util.*;

class Solution {

    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for (int j = 0; j < schedules.length; j++) {
            int schedule = schedules[j];
            int count = 0;
            
            // 7일간 모든 출근 기록을 순회
            for (int offset = 0; offset < 7; offset++) {
                int day = (startday + offset - 1) % 7 + 1; // 요일 계산 (1 ~ 7)
                
                // 주말(토, 일)은 출근 기록만 무시 (count 증가 X)
                if (day == 6 || day == 7) continue;
                
                int timelog = timelogs[j][offset]; // 주어진 timelogs 배열은 항상 7일을 제공
                if (isValid(schedule, timelog)) {
                    count++;
                }
            }
            
            if (count == 5) {
                answer++;
            }
        }

        return answer;
    }
    
    public static boolean isValid(int schedule, int timelog) {
        int scheduleHour = schedule / 100;
        int scheduleMinute = schedule % 100;
        int timelogHour = timelog / 100;
        int timelogMinute = timelog % 100;
        
        if (timelog <= schedule) {
            return true; // 정해진 시간보다 빠르면 정상 출근
        }
        
        int hourDiff = timelogHour - scheduleHour;
        
        if (hourDiff > 1) {
            return false;
        }
        
        if (hourDiff == 0) {
            return timelogMinute <= scheduleMinute + 10;
        }
        
        if (hourDiff == 1) {
            return (scheduleMinute + 10 >= 60) && (timelogMinute <= (scheduleMinute + 10 - 60));
        }
        
        return false;
    }
}