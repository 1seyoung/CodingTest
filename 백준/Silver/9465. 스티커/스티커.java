
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    // scan T
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());


    // for T

    for (int i = 0; i<t; i++){
      // scan n
      int n = Integer.parseInt(br.readLine());
      int[][] sticker = new int[2][n]; // 행 열

      for(int j = 0; j <2; j++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int k =0 ; k < n; k++) {
          sticker[j][k] = Integer.parseInt(st.nextToken());
        }
      }

      //dp
      //가장 큰거붙어 뜯고 저장 -> 상하좌우 삭제 -> 또 큰거 뽑 -> x greedy 에 더 가까움 적합 x
      // 당장의 최대 x
      int [][] dp = new int[2][n];

      //직접 써보니깐 일단 맨 첫 열에서 하나를 골라 그러면 자연스럽게 다음 선택지가 보이는데 대각선에 있는게 남지 그럼
      // 이제 선택할게 대각선에 있는 것을 선택할지 아니면 그걸 죽이고 다음 열에 있는걸 선택할지

      dp[0][0] = sticker[0][0];
      dp[1][0] = sticker[1][0];

      //dp[0][i] = Math.max(dp[1][i+1], Math.max(dp[0][i+2], dp[1][i+2])) + 미래를 보는 방법 x dp 는 과거를 봐야함

      if (n > 1) {
        dp[0][1] = dp[1][0] + sticker[0][1];
        dp[1][1] = dp[0][0] + sticker[1][1];
      }

      for(int x =2; x<n;x++){
        dp[0][x] = Math.max(dp[1][x-1], Math.max(dp[1][x-2],dp[0][x-2])) + sticker[0][x];
        dp[1][x] = Math.max(dp[0][x-1], Math.max(dp[0][x-2], dp[1][x-2])) + sticker[1][x];
      }

      System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));


    }

  }

}
