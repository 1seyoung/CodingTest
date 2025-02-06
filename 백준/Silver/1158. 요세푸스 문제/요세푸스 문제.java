import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
요세푸스 문제

상황
1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있음
양수 K -> 순서대로 k번째 사람을 제거

한 사람이 제거되면 다시 원을 이루고 반복한다.

종료 조건
N명의 사람이 모두 제거될때

입력 N , K
출력 원에서 제거되는 순서 출력

로직
1. N번까지 배열 만들기 (원형 큐)
2. K번째 사람 제거하기
    2-1 큐 두개 만들기
    2-2 k-1 번까지 앞에 큐에 넣기
    2-3 기존 큐에서 k 번 pop
    2-4 나머지 데이터 옮기기(3번 과정을 의미함)
3. k-1 k+1 번 사람 연결하기 ( 다시 기존 큐로 옮겨)
4. 사람 다 제거할때까지 무한 반복
 */
public class Main {
    public static void main(String[] args) {
        //추출한 값을 담을 객체 생성
        StringBuilder result = new StringBuilder();
        result.append("<");


        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.close();

        // 1. N번까지 배열 만들기 (원형 큐로 구현)
        Queue<Integer> mainQueue = new LinkedList<>();
        Queue<Integer> tempQueue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            mainQueue.add(i);
        }


        // 4. 사람 제거할 때 까지 반복 -> while
        while(!mainQueue.isEmpty() || !tempQueue.isEmpty()) {
//            //2-1, 2-2 -> k-1번까지 앞에 큐 넣기
//            for(int i = 0 ; i <K-1; i++) {
//                //넣는 과정에서 기존 큐에서 사람이 안남으면 오류남
//                if(!mainQueue.isEmpty()) {
//                    tempQueue.add(mainQueue.poll()); // poll() : 맨 앞의 원소 꺼내고 삭제 / add()  : 원소 추가
//                }
//            }
            // ------------------------------------
            int count = K-1;
            while (count > 0) {
                if(mainQueue.isEmpty()) {
                    while (!tempQueue.isEmpty()) {
                        mainQueue.add(tempQueue.poll());
                    }
                }
                tempQueue.add(mainQueue.poll());
                count --;
            }

            // K번째 찾기 :  K-1개를 tempQueue로 이동한 후, K번째 숫자를 제거하기 직전에 mainQueue가 비어있는 상황을 처리하기 위한 코드
            if(mainQueue.isEmpty()) {
                while(!tempQueue.isEmpty()) {
                    mainQueue.add(tempQueue.poll());
                }
            }

            //---------------------------------

            // 2-3 K번째 사람 제거하고 결과에 추가
            result.append(mainQueue.poll());
            // result 에 쉼표 넣어야함 ex) < 2, 3, 1>
            if(!mainQueue.isEmpty() || !tempQueue.isEmpty()) {
                result.append(", ");
            }


//            // 2-4 , 3 나머지 데이터 옮기고 연결하기
//            while (!mainQueue.isEmpty()) {
//                tempQueue.add(mainQueue.poll());
//            }
//
//            //3. ( 다시 기존 큐로 옮겨)
//            while (!tempQueue.isEmpty()) {
//                mainQueue.add(tempQueue.poll());
//            }

        }

        result.append(">");
        System.out.println(result);
        
    }
}
