import java.util.*;

public class Main {
    static char[][] tile;
    static char[] lastColor;
    static int curIdx;
    static int line;
    static int offset = 100; // 음수 좌표 방지용

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        tile = new char[n][offset];
        lastColor = new char[offset];
        curIdx = offset / 2; // 시작점을 가운데로
        line = 0;

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);
            coloringTile(x, dir);
        }

        int wCount = 0;
        int bCount = 0;
        int gCount = 0;

        // 각 칸의 최종 색상 통계 계산
        for (int j = 0; j < offset; j++) {
            int blackCnt = 0;
            int whiteCnt = 0;

            for (int i = 0; i < n; i++) {
                if (tile[i][j] == 'B') blackCnt++;
                if (tile[i][j] == 'W') whiteCnt++;
            }

            if (blackCnt >= 2 && whiteCnt >= 2) {
                gCount++;
            } else {
                if (lastColor[j] == 'W') wCount++;
                if (lastColor[j] == 'B') bCount++;
            }
        }

        System.out.println(wCount + " " + bCount + " " + gCount);
        sc.close();
    }

    public static void coloringTile(int x, char dir) {
        if (dir == 'R') {
            for (int i = curIdx; i < curIdx + x; i++) {
                tile[line][i] = 'B';
                lastColor[i] = 'B';
            }
            if (x > 1) curIdx += x - 1; // 현재 위치 포함이므로 x-1칸만 이동
            line++;
        } else { // L
            for (int i = curIdx; i > curIdx - x; i--) {
                tile[line][i] = 'W';
                lastColor[i] = 'W';
            }
            if (x > 1) curIdx -= x - 1;
            line++;
        }
    }
}
