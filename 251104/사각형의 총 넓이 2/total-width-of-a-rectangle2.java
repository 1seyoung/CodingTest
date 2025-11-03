import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        boolean[][] board = new boolean[201][201];
        int OFFSET = 100;

        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt()+ OFFSET;
            int y1 = sc.nextInt()+ OFFSET;
            int x2 = sc.nextInt()+ OFFSET;
            int y2 = sc.nextInt()+ OFFSET;

            for(int x = x1; x < x2; x++){
                for(int y = y1; y< y2; y++){
                    board[x][y] = true;
                }

            }

        }

        int area = 0;
        for(int i = 0; i < 201; i++){
            for(int j = 0; j <201; j++){
                if (board[i][j]) area++;
            }
        }

        System.out.print(area);
    }
}