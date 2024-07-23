package codingtest_week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no2_boj2615 {
    public static void main(String[] args) throws IOException {
        //1. 오목판 초기화 19 x 19
        int[][] omok = new int[19][19];


        //2. 오목판 상태 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 19; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 19; j++) {
                omok[i][j] = Integer.parseInt(line[j]);
            }
        }

        //3. 검은 바둑알은 1, 흰 바둑알은 2, 알이 놓이지 않는 자리는 0으로 표시
        //첫줄에 검은색이 이겼을 경우에는 1을, 흰색이 이겼을 경우에는 2를, 아직 승부가 결정되지 않았을 경우에는 0을 출력한다
        // 검은색 또는 흰색이 이겼을 경우에는 둘째 줄에 연속된 다섯 개의 바둑알 중에서 가장 왼쪽에 있는 바둑알(연속된 다섯 개의 바둑알이 세로로 놓인 경우, 그 중 가장 위에 있는 것)의 가로줄 번호와, 세로줄 번호를 순서대로 출력한다.


        //3-1 (0,0) 부터 시작해서 상하좌우 판단 + 대각선
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        //일단 다 돌기..? -> 완전 탐색


        // 오목판 출력 (디버깅용)
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                System.out.print(omok[i][j] + " ");
            }
            System.out.println();
        }

    }
}
