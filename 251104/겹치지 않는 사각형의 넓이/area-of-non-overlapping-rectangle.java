import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Please write your code here.

        int[][] board  = new int[2001][2001];
        int OFFSET = 1000;

        int ax1 = sc.nextInt()+OFFSET;
        int ay1 = sc.nextInt()+OFFSET;
        int ax2 = sc.nextInt()+OFFSET;
        int ay2 = sc.nextInt()+OFFSET;
        int bx1 = sc.nextInt()+OFFSET;
        int by1 = sc.nextInt()+OFFSET;
        int bx2 = sc.nextInt()+OFFSET;
        int by2 = sc.nextInt()+OFFSET;
        int mx1 = sc.nextInt()+OFFSET;
        int my1 = sc.nextInt()+OFFSET;
        int mx2 = sc.nextInt()+OFFSET;
        int my2 = sc.nextInt()+OFFSET;

        for(int x = ax1; x < ax2; x++){
            for(int y = ay1; y < ay2; y++){
                board[x][y] = 1;
            }
        }
        for(int x = bx1; x < bx2; x++){
            for(int y = by1; y < by2; y++){
                board[x][y] = 2;
            }
        }

        for(int x = mx1; x < mx2; x++){
            for(int y = my1; y < my2; y++){
                board[x][y] = 3;
            }
        }

        int area =0;
        for(int i = 0; i < 2001; i++){
            for(int j = 0; j < 2001; j++){
                if(board[i][j]==1) area++;
                if(board[i][j]==2) area++;
            }
        }

        System.out.print(area);
        
    }
}