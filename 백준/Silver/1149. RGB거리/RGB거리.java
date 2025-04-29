
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * RGB 거리에는 N개의 집 1- N 번의 집
 * 집 색 : 빨 초 파 중 1 -> 각 집의 색칠 비용 주어짐
 * rule
 * 1. 1번 집은 2번 집과 색이 같지 않아야한다.
 * 2. N 번 집의 색은 N-1 번 집과 색이 같지 않아야한다.
 * 3. i 번 집의 색은 i-1 번 집과 색이 같지 않아야한다.
 *
 * >> 요약 : 양 옆의 집과 색이 같지 않아야함
 *
 * dp
 *
 * 당장 생각나는 선택지 1번 집의 색을 정한다/ 마지막 집의 색을 정한다 해서 다 탐색해서 min 구하기 (마지막의 선택이 전의 선택에 영향)(첫집을 시작으로 1번부터)
 */

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // scan N
    int n = Integer.parseInt(st.nextToken());

    // scan RGB
    int[][] RGB = new int[n][3];

    for(int i =0; i < n; i++){
      st = new StringTokenizer(br.readLine());
      RGB[i][0] = Integer.parseInt(st.nextToken());
      RGB[i][1] = Integer.parseInt(st.nextToken());
      RGB[i][2] = Integer.parseInt(st.nextToken());
    }

    // [][1] : R , [][2] : G , [][3] : B
    int[][] dp = new int[n][3]; // 선택에 대한 값을 저장한다

    // init dp
    dp[0][0] = RGB[0][0];
    dp[0][1] = RGB[0][1];
    dp[0][2] = RGB[0][2];


    for (int i = 1; i < n ; i++){
      dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + RGB[i][0]; // i번째 집을 빨간색으로 -> i-1 은 파랑 dp[i-1][2] or 초록  dp[i-1][1]
      dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + RGB[i][1];
      dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + RGB[i][2];
    }

    int min = Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    System.out.println(min);

    
  }
}
