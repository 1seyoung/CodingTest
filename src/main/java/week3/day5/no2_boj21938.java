package week3.day5;

import java.util.Scanner;

public class no2_boj21938 {
    static int M, N, T;
    static int[][] image;
    static boolean[][] visited;

    // 상하좌우 방향 벡터
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        // 1. 입력 처리
        // 1-1 격자 정보 입력 받기 (M,N)
        N = sc.nextInt();
        M = sc.nextInt();

        // 1-2 RGB값 입력받기 -> 평균값 계산 필요하니 각자?
        int[][] R = new int[N][M];
        int[][] G = new int[N][M];
        int[][] B = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                R[i][j] = sc.nextInt();
                G[i][j] = sc.nextInt();
                B[i][j] = sc.nextInt();  //왜 여기서 바로 평균 계산을 안했냐면 이거를 받고 경계값을 입력 받을 것이라서
            }
        }

        //1-3 경계값 입력
        T = sc.nextInt();
        sc.close();

        //1-4 격자 초기화 및 변수 정의(새로우 물체...?)

        image = new int[N][M];
        visited = new boolean[N][M];
        int count=0;
        int aver;

        //2 평균값 계산해서 경계값 비교 -> image 격자 채우기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                aver = (R[i][j] + G[i][j] + B[i][j]) / 3;

                if (aver >= T) {
                    //평균이 경계값 보다 큰거나 같으면 255
                    image[i][j] = 1; //255로 안해도될듯함 1이라 생각해도될듯
                }else {
                    image[i][j] = 0;
                }
            }
        }

        //3 물체 인식 및 개수 세기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (image[i][j] == 1 && !visited[i][j]) {
                    dfs(i,j);
                    count++;
                }
            }
        }

        System.out.print(count);

    }
    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx >=0 && nx <N && ny >=0 && ny <M && image[nx][ny] == 1 && !visited[nx][ny]){
                dfs(nx,ny);
            }
        }
    }
}
