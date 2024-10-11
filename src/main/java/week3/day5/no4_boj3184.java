package week3.day5;

import java.util.Scanner;

public class no4_boj3184 {
    static int R,C; // 행열  --> R개의 줄은 C개의 글자를 가진다

    static char[][] ranch;
    static boolean[][] visited;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static int sheepCount = 0;  // 살아남은 양의 수
    static int wolfCount = 0;  // 살아남은 늑대의 수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();  // 개행 문자 제거


        ranch = new char[R][C];
        visited = new boolean[R][C];  // visited 배열 초기화


        String obj;

        for (int i = 0; i < R; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < C; j++) {
                ranch[i][j] = line.charAt(j);
            }
        }

        sc.close();
        /*
        글자 '.' (점)은 빈 필드를 의미
        글자 '#'는 울타리를,
        'o'는 양,
        'v'는 늑대를 의미한다.

        영역 > 울타리 기준
        영역 안에  양 > 늑대 --> 늑대 쫓겨남 , 양이 이겨
        영역 안에 양 < 늑대 --> 늑대가 양 다 먹어

        ?쫓겨나면 어디로 가는가?
         */

        //일단 마당 탐색
        //그리고 영역안에 늑대 몇마리 양 몇마리 저장해
        int[] result ;
        int localSheep;
        int localWolf;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if ((ranch[i][j] == 'o' || ranch[i][j] == 'v')&& !visited[i][j]) {//양이나 늑대 있으면 탐색해 그 영역을
                    result = dfs(i,j);
                    localSheep = result[0];
                    localWolf = result[1];

                    //양이랑 늑대 수 비교해
                    if (localSheep > localWolf) {
                        sheepCount += localSheep;
                    } else {
                        wolfCount += localWolf;
                    }

                }
            }
        }

        System.out.print(sheepCount + " " + wolfCount);

    }
    private static int[] dfs(int x, int y) {
        int localSheep = 0;
        int localWolf = 0;
        visited[x][y] = true;

        //일단 영역 안에 얼마나 있는지 더해
        if (ranch[x][y] == 'o') {
            localSheep++;
        }else if (ranch[x][y] == 'v') {
            localWolf++;
        }

        //상화좌우 탐색 -> dfs 격자 문제 필수
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx>=0 && nx<R && ny>=0 && ny<C && !visited[nx][ny] && ranch[nx][ny] != '#') {//울타리가 아니어야함 -> 울타리면 탐색 불가능?
                int[] result = dfs(nx, ny);
                localSheep += result[0];
                localWolf += result[1];

            }
        }

        return new int[]{localSheep, localWolf};

    }
}
