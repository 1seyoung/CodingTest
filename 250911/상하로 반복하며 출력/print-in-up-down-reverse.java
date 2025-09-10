import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();

        int[][] array = new int[N][N];
    

        for(int j = 0; j < N; j++){
            if(j %2 == 0){
                for(int i = 0; i <N; i++){
                    array[i][j] = i+1;
                }
            } else {
                for(int k = 0; k <N; k++){
                    array[k][j] = N-k;
                }
            }

        }


        for(int i = 0; i <N; i++){
            for(int j = 0; j<N;j++){
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}