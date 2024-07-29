package week2.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class no2_boj1927 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. N입력받기
        int N = Integer.parseInt(br.readLine().trim());


        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        /*
        뭅법 참고
        최소값 조회 (루트 노드)
        System.out.println("Minimum value: " + minHeap.peek());  // 출력: 2

        최소값 추출 (루트 노드 제거)
        System.out.println("Extracted minimum value: " + minHeap.poll());  // 출력: 2

        모든 요소 출력
        System.out.println("All elements in the min-heap: " + minHeap);

         */

        int command;

        //2. N만큼 반복문
        for (int i = 0; i < N; i++) {
            command = Integer.parseInt(br.readLine().trim());

            if(command >0){
                minHeap.add(command);
            }

            if (command == 0) {
                if(minHeap.isEmpty()){
                    System.out.println(0);
                } else {
                    //2-1 명령어가 0이면 배열에서 가장 작은 값 출력하고 그 값 배열에서 제거 -> Poll
                    System.out.println(minHeap.poll());  // 출력: 2
                }

            }

        }


    }
}
