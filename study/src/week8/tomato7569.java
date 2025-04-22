package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class tomato7569 {
  static int[][][] box;
  static Queue<int[]> queue = new ArrayDeque<>();

  static int dn[] = {1, -1, 0, 0, 0, 0}; // 세로
  static int dm[] = {0, 0, 1, -1, 0, 0}; // 가로
  static int dh[] = {0, 0, 0, 0, 1, -1}; // 높이

  public static void main(String[] args) throws IOException {
    /**
     * 인접한 토마토란 : 6가지 방향(상하좌우, 위아래) 에 접하고 있는 토마토
     * 대각선은 영향을 줄 수 없고 저절로 익을 수 없음
     *
     * 익는 기준 : 익은 토마토의 인접한 곳에 있는 익지 않은 토마토가 익는다 언제? 다음날에
     * 토마토가 없을 수도 있다.
     *
     * 익은 토마토가 여러 개 -> 동시에 탐색 시작점
     *
     * 익은 토마토 1 / 익지 않은 토마토 0 / 빈칸 -1
     *
     *  입력
     *  M N H
     *  밑층부터의 토마토 정보 (H만큼 반복)
     *
     *  출력
     *  모든 토마토가 익는데 걸리는 최소 일수
     *  만약 애초에 모든 토마토가 익어있으면? 0
     *  만약 애초에 모든 토마토가 익지 않는다면? -1
     *
     *
     *  //로직
     *
     *  1. M,N H 입력받기
     *  2. H 만큼 반복해서 M*N만큼 토마토 정보 입력받기(변수 이름 box)
     *
     *  3. 익은 토마토 위치 확인 -> 어디에 담아두나? 큐 -?> 왜? BFS를 위해서(큐 기반 탐색)
     *
     *  4. 익은 토마토 기준으로 탐색 -> 어떤 알고리즘? -> BFS ? 왜? 목표가 최소 일수이기 때문에 -> BFS는 최단 거리(또는 최소 시간) 문제에서 가장 자주 쓰이는 알고리즘
     *
     *  (3,4 익은 토마토의 좌표를 모두 큐에 담고,
     * 거기서부터 BFS로 주변 토마토를 익히는 방식으로 탐색을 진행)
     *
     * 5.  모든 토마토가 익었는지 확인
     * 6. 날짜 출력(다 안익는지 최종적인 결론은 어떻게 내는가? box 안에 0이 하나라도 남아 있으면 → -1 )
     */

    // scan M,N, H
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int H = Integer.parseInt(st.nextToken());

    box = new int[H][N][M]; // box[층][행][열]
    queue = new ArrayDeque<>();

    // for H번
    for (int h = 0; h < H; h++){
      // for br.한줄읽기 N번
      for(int n = 0; n <N; n++) {
        st = new StringTokenizer(br.readLine());
        // for 한줄 쪼개서 토큰화 M번
        for(int m = 0; m<M; m++){
          box[h][n][m] = Integer.parseInt(st.nextToken());
          // if 토마토 상태 = 1 -> q.add
          if (box[h][n][m] == 1) {
            //queue.add({h, n, m, day}); // 컴파일 에러
            queue.offer(new int[] {h, n, m, 0});
          }
        }
      }
    }

    int[] currentTomato;
    int maxDay = 0;

    // if q not empty
    while(queue.size() > 0) {
      // q 에서 토마토 꺼내
      currentTomato = queue.poll();
      // bfs 6
      for(int i = 0; i < 6; i++){
        int nh = currentTomato[0] + dh[i];
        int nn = currentTomato[1] + dn[i];
        int nm = currentTomato[2] + dm[i];

        // if in box and not visited
        if (nh >= 0 && nh < H && nn >= 0 && nn < N && nm >= 0 && nm < M) {
          if (box[nh][nn][nm] == 0) {
            // check visited
            box[nh][nn][nm] = 1;
            queue.offer(new int[] {nh,nn, nm, currentTomato[3] +1});
            maxDay = Math.max(maxDay, currentTomato[3] +1);
          }
        }
      }
    }

    // if tomato not visited
    boolean hasUnripe = false;

    for (int h = 0; h < H; h++) {
      for (int n = 0; n < N; n++) {
        for (int m = 0; m < M; m++) {
          if (box[h][n][m] == 0) {
            hasUnripe = true;
            break;
          }
        }
        if (hasUnripe) break;
      }
      if (hasUnripe) break;
    }

    if (hasUnripe) System.out.println(-1);
    else System.out.println(maxDay);

  }
}
