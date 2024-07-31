
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); // 정수 입력 후 개행 문자를 소비합니다.
        int[] ticketValue = new int[N];

        int maxValue = Integer.MIN_VALUE;
        String[] line = sc.nextLine().split(" ");

        for (int i = 0; i < N; i++) {
            ticketValue[i] = Integer.parseInt(line[i]);
            if (maxValue < ticketValue[i]) {
                maxValue = ticketValue[i];
            }
        }


        //int[] minTicketValue = new int[maxValue]; // [1,2,3,...,maxValue]
        // 배열을 1부터 maxValue까지 초기화
        //for (int i = 0; i < maxValue; i++) {
        //    minTicketValue[i] = i + 1;
        //}
        Set<Integer> minTicketValue = new HashSet<>();
        for (int i = 1; i <= maxValue; i++) {
            minTicketValue.add(i);
        }

        for (int value : ticketValue) {
            minTicketValue.remove(Integer.valueOf(value));
        }


        // 리스트에서 가장 작은 값을 출력
        if (!minTicketValue.isEmpty()) {
            System.out.println(minTicketValue.iterator().next()); // 가장 작은 값 출력 // gpt 코드 부분 -> TreeSet에 대해서 찾아보기
        } else {
            // 만약 모든 값이 포함되어 제거된 경우, maxValue + 1 출력
            System.out.println(maxValue + 1);
        }
    }
}
