package week2.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class boj10845 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String command;
        Queue<Integer> queue = new LinkedList<>();

        while (n-- > 0) {
            command = br.readLine();
            Queue(command,queue);
        }


    }
    static void Queue(String command, Queue<Integer> queue){

        int number;
        try {
            // 명령어가 숫자를 포함하고 있는지 확인하고 숫자를 추출
            number = Integer.parseInt(command.split(" ")[1]);
            // 숫자가 포함된 경우는 무조건 "push" 명령어이므로 push 처리
            //case push;
            queue.add(number);
        } catch (Exception e) {
        switch (command) {
            case "pop":
                //큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue.poll());
                }
                break;

            case "size":
                //큐에 들어있는 정수의 개수를 출력한다.
                System.out.println(queue.size());
                break;

            case "empty":
                //큐가 비어있으면 1, 아니면 0을 출력한다.
                System.out.println(queue.isEmpty() ? 1 : 0);
                break;

            case "front":
                //큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue.peek());
                }
                break;

            case "back":
                //큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(((LinkedList<Integer>) queue).getLast());
                }
                break;
        }

        }

    }
}
