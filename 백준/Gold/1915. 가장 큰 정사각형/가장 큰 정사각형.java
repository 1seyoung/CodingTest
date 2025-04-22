import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr = new int[1001][1001]; // DP 배열 (패딩 적용)
    static int n, m; // 행렬 크기 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sqrtAns = 0; // 가장 큰 정사각형 한 변의 길이

        // 행렬 크기 입력 받기
        n = Integer.parseInt(st.nextToken()); // 행 개수
        m = Integer.parseInt(st.nextToken()); // 열 개수

        // 행렬 데이터 입력 받기
        for (int y = 1; y <= n; y++) {
            String line = br.readLine();
            for (int x = 1; x <= m; x++) {
                arr[y][x] = line.charAt(x-1) - '0'; // 문자 '0' 또는 '1'을 숫자로 변환하여 저장
            }
        }

        // DP 테이블 채우기
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                if (arr[y][x] != 0) { // 현재 위치가 1인 경우에만 처리
                    arr[y][x] = Math.min(Math.min(arr[y-1][x], arr[y][x-1]), arr[y-1][x-1]) + 1; // DP 점화식 적용
                    sqrtAns = Math.max(arr[y][x], sqrtAns); // 최대 정사각형 크기 업데이트
                }
            }
        }

        // 최대 정사각형의 넓이 출력 (한 변의 길이의 제곱)
        System.out.println(sqrtAns * sqrtAns);
        br.close();
    }
}