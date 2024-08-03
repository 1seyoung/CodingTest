import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static char[][] grid;
  static int treasuresFound = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] dimensions = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    grid = new char[dimensions[0]][dimensions[1]];
    int[] startPos = new int[2];

    // 맵 초기화 및 시작 위치 설정
    for (int i = 0; i < dimensions[0]; i++) {
      String row = br.readLine();
      for (int j = 0; j < dimensions[1]; j++) {
        grid[i][j] = row.charAt(j);
        if (grid[i][j] == 'I') {
          startPos[0] = i;
          startPos[1] = j;
        }
      }
    }

    boolean[][] visited = new boolean[dimensions[0]][dimensions[1]];
    dfs(startPos[0], startPos[1], visited);

    if (treasuresFound > 0) {
      System.out.println(treasuresFound);
    } else {
      System.out.println("TT");
    }
  }

  public static void dfs(int x, int y, boolean[][] visited) {
    visited[x][y] = true;

    // 보물 발견 시 카운트 증가
    if (grid[x][y] == 'P') {
      treasuresFound++;
    }

    // 방향 벡터 배열 (동서남북)
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    // 동서남북으로 탐색
    for (int dir = 0; dir < 4; dir++) {
      int newX = x + dx[dir];
      int newY = y + dy[dir];

      if (isInBounds(newX, newY) && grid[newX][newY] != 'X' && !visited[newX][newY]) {
        dfs(newX, newY, visited);
      }
    }
  }

  // 유효한 좌표인지 확인
  public static boolean isInBounds(int x, int y) {
    return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
  }

}
