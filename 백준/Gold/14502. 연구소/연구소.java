
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * N : 세로(행)
 * M : 가로(열)
 *
 * 0 빈칸 / 1 벽 / 2 바이러스
 * 추가로 꼭 3개의 벽을 더 만들어서 안전 구역의 넓이를 계산하기
 *
 * 벽을 3개를 꼭 둬야한다.
 */
public class Main {
  static int maxSafeArea = 0;
  static int[][] room;
  static List<int[]> virusList = new ArrayList<>();
  static List<int[]> emptyList = new ArrayList<>();

  static int N, M;

  static int dx[] = { -1, 1, 0, 0 };
  static int dy[] = { 0, 0, -1, 1 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    virusList = new ArrayList<>();
    emptyList = new ArrayList<>();

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    room = new int[N][M];

    for (int n = 0; n < N; n++) {
      st = new StringTokenizer(br.readLine());
      for (int m = 0; m < M; m++) {
        room[n][m] = Integer.parseInt(st.nextToken());
        if (room[n][m] == 2)
          virusList.add(new int[]{n, m});
        if (room[n][m] == 0) {
          emptyList.add(new int[]{n, m});
        }
      }
    }

    // 벽 세우는 조합? 왜 조합? 빈칸 중에서 3개 고르는거라
    // emptyList. 에서 3개 뽑아

    makeWall(0, 0);
    System.out.println(maxSafeArea);
  }


  static void makeWall(int depth, int start) {
    if(depth == 3) {
      simulate();
      return;
    }

    for (int i = start; i < emptyList.size(); i++) {
      int[] wall = emptyList.get(i);
      room[wall[0]][wall[1]] = 1; // 벽 세우기
      makeWall(depth + 1, i + 1); // 다음 벽 세우기
      room[wall[0]][wall[1]] = 0; // 벽 없애기
    }

  }

  static void simulate() {
    // room copy
    int[][] copyRoom = new int[N][M];
    for (int i = 0; i < N; i++) {
      copyRoom[i] = room[i].clone();
    }

    // 바이러스 저장
    Queue<int[]> queue = new ArrayDeque<>();
    for (int[] v : virusList) {
      queue.offer(new int[]{v[0], v[1]});
    }

    while (queue.size() > 0) {
      int[] current = queue.poll();
      for (int i = 0; i < 4; i++) {
        int ny = current[0] + dy[i];
        int nx = current[1] + dx[i];

        if (ny < 0 || nx < 0 || ny >= N || nx >= M)
          continue;
        if (copyRoom[ny][nx] == 0) {
          copyRoom[ny][nx] = 2;
          queue.offer(new int[]{ny, nx});
        }
      }
    }

    int safeArea = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (copyRoom[i][j] == 0)
          safeArea++;
      }

    }
    
    maxSafeArea = Math.max(maxSafeArea, safeArea);
  }

  }
