
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int MAX = 100001;
    static int N, K;
    static boolean[] visited = new boolean[MAX];

    static class Point {
      int pos, time;
      Point(int pos, int time) {
        this.pos = pos;
        this.time = time;
      }
    }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    System.out.println(bfs());

  }

  static int bfs() {
    Deque<Point> queue = new ArrayDeque<>();
    queue.offer(new Point(N,0));
    visited[N] = true;

    while(!queue.isEmpty()){
      Point cur = queue.poll();
      int pos = cur.pos;
      int time = cur.time;

      if (pos == K) return time;

      // 순간이동이 항상 빠르니깐 먼저 처리??
      int next = pos *2;
      // 제일 앞에 넣기
      if (next < MAX && !visited[next]) {
        visited[next] = true;
        queue.offerFirst(new Point(next, time));
      }

      // 걷기 1초
      for (int move : new int[]{pos - 1, pos + 1}) {
        if (move >= 0 && move < MAX && !visited[move]) {
          visited[move] = true;
          queue.offerLast(new Point(move, time + 1));
        }
      }
    }

    return -1;
  }
}
