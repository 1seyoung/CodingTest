package week2.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class no3_boj14235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int command;

        while (N-- > 0) {
            String[] input = br.readLine().split(" ");
            command = Integer.parseInt(input[0]);

            if (command == 0) {
                //아이들 만났을 때
                if (maxHeap.isEmpty()) {
                    System.out.println(-1);
                }else{
                    System.out.println(maxHeap.poll());
                }
            }

            if (command > 0) {
                for (int j = 1; j <= command; j++) {
                    int giftValue = Integer.parseInt(input[j]);
                    maxHeap.add(giftValue);
                }
            }


        }


    }
}
