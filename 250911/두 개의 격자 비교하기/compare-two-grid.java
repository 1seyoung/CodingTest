import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] array1 = new int[N][M];
        int[][] array2 = new int[N][M];

        for(int i = 0; i <N; i++){
            for(int j =0;j<M; j++){
                int input = sc.nextInt();
                array1[i][j] = input;
            }
        }

        for(int i = 0; i <N; i++){
            for(int j = 0; j <M; j++){
                int input2 = sc.nextInt();
                if(array1[i][j] == input2){
                    array2[i][j] = 0;
                } else {
                    array2[i][j] =1;
                }
            }
        }

        for(int i = 0; i <N; i++){
            for(int j =0;j<M; j++){
                System.out.print(array2[i][j]+" ");
            }
            System.out.println();
        }
    }
}