
import java.util.Scanner;

public class Main {
    static int N,M,K;

    static int[][] food;
    static boolean[][] visited;

    // 상하좌우 방향 벡터
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static int maxCount = Integer.MIN_VALUE;
    static int count =0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        K = sc.nextInt();

        food = new int[N][M];
        visited = new boolean[N][M];  // visited 배열 초기화


        int x,y;

        for(int i = 0;i < K;i++){
            x = sc.nextInt()-1;
            y = sc.nextInt()-1;
            food[x][y] = 1;

        }

        //3 물체 인식 및 개수 세기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (food[i][j] == 1 && !visited[i][j]) {
                    count =0;
                    dfs(i,j);
                    if (count > maxCount) maxCount = count;
                }
            }
        }

        System.out.println(maxCount);
    }
    static void dfs(int x,int y) {
        visited[x][y] = true;
        count ++;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx >=0 && nx <N && ny >=0 && ny <M && food[nx][ny] == 1 && !visited[nx][ny]){
                dfs(nx,ny);
            }

            }
    }
}
