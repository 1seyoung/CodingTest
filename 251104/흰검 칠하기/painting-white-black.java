import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int offset = 200001;
        int cur = offset / 2;

        int[] whiteCnt = new int[offset];
        int[] blackCnt = new int[offset];
        char[] color = new char[offset];

        for (int k = 0; k < n; k++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);

            if (dir == 'R') {
                for (int i = cur; i < cur + x; i++) {
                    blackCnt[i]++;
                    color[i] = 'B';
                }
                if (x > 1) cur += x - 1;
            } else {
                for (int i = cur; i > cur - x; i--) {
                    whiteCnt[i]++;
                    color[i] = 'W';
                }
                if (x > 1) cur -= x - 1;
            }
        }

        int w = 0, b = 0, g = 0;
        for (int i = 0; i < offset; i++) {
            if (whiteCnt[i] >= 2 && blackCnt[i] >= 2) g++;
            else if (color[i] == 'W') w++;
            else if (color[i] == 'B') b++;
        }

        System.out.println(w + " " + b + " " + g);
    }
}
