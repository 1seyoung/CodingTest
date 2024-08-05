package week3.day5;

import java.util.Scanner;

public class no1_boj13565 {
    static int M, N;
    static int[][] grid;
    static boolean[][] visited;

    //2-1 방향 정의(상화좌우)
    // 상하좌우 방향 벡터
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);


        // 1. 입력 처리
        // 1-1 격자 정보 입력 받기 (M,N)
        M = sc.nextInt();
        N = sc.nextInt();
        sc.nextLine(); // 개행 문자 제거

        //1-2 격자 초기화 및 변수 정의

        grid = new int[M][N];
        visited = new boolean[M][N];

        // 1-3 격자 상태 정보 업데이트 -> 이중 포문
        for (int i = 0; i < M; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = line.charAt(j) - '0'; //// 문자를 정수로 변환
            }
        }
        sc.close();

        //2, 탐색 -> DFS or BFS
        // 현재 위치에서 상화좌우 하는 탐색 -> 한 경로를 끝까지 탐색하고 다른 경로를 보는 것이기 때문에 DFS(특정 경로가 목적지에 도달할 수 있는지 확인)
        boolean tingling = false; // 전류 통과 여부

        //2-1 방향 정의 -> 전역변수에 정의해둠
        //2-2 0,0 부터 모든 흰색 격자에 대한 탐색 (0 -> 전류 통함 // 1-> 전류 안통함)
        for (int k = 0; k < N; k++) {
            //2-3 DFS 탐색 전 초기 조건 확인
            if (grid[0][k] == 0 && !visited[0][k]){ // 전류가 가능한 흰색 "이고" 아직 방문을 안했을 때 (&& and , || or)
                //2-4
                if (dfs(0, k)){ //dfs 결과가 true 이면
                    tingling = true; // 전기가 통함으로 바꾸고
                    break; // 통하니깐 더 안찾아도됨
                }

                //결과 false 면 다음 시작 점 부터 다시 탐색
            }

        }

        if (tingling){
            System.out.println("YES");
        }
        if(!tingling){
            System.out.println("NO");
        }

    }

    static boolean dfs(int x, int y) {
        //x : 행 , y : 열
        if (x == M-1){  // 행이 m-1 이면 innerside 도착 -> 전류 통함
            return true;
        }

        visited[x][y] = true;  // 입력 받은 인덱스 방문했음 체크

        //현재 위치에서 상하좌우 탐색(-> 4)
        for(int i=0; i<4; i++){
            int nx = x +dx[i];
            int ny = y +dy[i];

            if (nx >= 0 && nx < M && ny >= 0 && ny < N && grid[nx][ny] == 0 && !visited[nx][ny]) {//이동한 좌표가 유효하면
                /*
                nx >=0 : 격자 행 인덱스 음수가 아니어야함
                nx < M : 격자의 전체 행수를 넘기면 x
                ny >=0 : 격자 열 인덱스 음수 x
               grid[nx][ny] == 0 : 이동한 좌표가 흰색(0인지) 이면 전류 통과~
                 */
                if (dfs(nx, ny)){
                    return true;
                }
            }
        }

        return false; // 모든 경로를 탐색해도 마지막 행 x -> 전류 안통함
    }
}
