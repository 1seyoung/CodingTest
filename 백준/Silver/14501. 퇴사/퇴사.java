import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt(); // 상담 기간
            arr[i][1] = sc.nextInt(); // 상담 금액
        }

        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int time = arr[i][0];
            int pay = arr[i][1];

            // 오늘 상담하는 경우
            if (i + time <= n) {
                dp[i + time] = Math.max(dp[i + time], dp[i] + pay);
            }

            // 오늘 상담 안 하는 경우
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        System.out.println(dp[n]);
    }
}