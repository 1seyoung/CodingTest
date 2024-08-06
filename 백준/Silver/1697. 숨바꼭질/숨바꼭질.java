import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int start; // 시작 위치
    static int target; // 목표 위치
    static int[] visited = new int[100001]; // 방문 체크 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        start = sc.nextInt(); // 시작 위치 입력
        target = sc.nextInt(); // 목표 위치 입력

        if (start == target) {
            System.out.println(0); // 시작 위치와 목표 위치가 같으면 0 출력
        } else {
            bfs(start); // BFS 실행
        }
    }

    static void bfs(int position) {
        Queue<Integer> queue = new LinkedList<>(); // BFS를 위한 큐
        queue.add(position); // 시작 위치 추가
        visited[position] = 1; // 시작 위치 방문 체크

        while (!queue.isEmpty()) {
            int current = queue.poll(); // 현재 위치

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = current + 1; // 한 칸 앞으로
                } else if (i == 1) {
                    next = current - 1; // 한 칸 뒤로
                } else {
                    next = current * 2; // 순간 이동
                }

                if (next == target) {
                    System.out.println(visited[current]); // 목표 위치 도달 시 결과 출력
                    return;
                }

                if (next >= 0 && next < visited.length && visited[next] == 0) {
                    queue.add(next); // 다음 위치 추가
                    visited[next] = visited[current] + 1; // 방문 체크 및 거리 갱신
                }
            }
        }
    }
}
