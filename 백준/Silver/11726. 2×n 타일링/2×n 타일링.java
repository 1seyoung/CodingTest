import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하
 *
 *첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
 *
 * 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
 */
public class Main {
  public static void main(String args[]) throws IOException {

    // scan n

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());

    // 1*2 를 따악 붙어서 다 넣고 나머지를 2*1 로 채우
    // 왜 dp? -? 처음 채운게 영향을 줘서???

    //dp[n] 가로길이가 n인 직사각형을 타일로 채우는 방법의 수
    // 끝에  1x2 타일을 세로로 놓는다 dp[-1
    // 끝에 2x1 타일을 가로로 나란히 dp[n-2]

    int[] dp = new int[n+1];

    //점화식 : dp[n] = dp[n-1] +dp[n-2]

    dp[1] = 1;

    if (n>=2) {dp[2] = 2;}


    for(int i =3; i<=n;i++){
      dp[i] =  (dp[i-1] + dp[i-2]) % 10007;
    }

    System.out.println(dp[n]);

  }

}
