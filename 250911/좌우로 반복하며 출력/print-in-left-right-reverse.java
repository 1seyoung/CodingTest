import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[N];


        for(int i = 0; i <N; i++){
            array[i]= i+1;
        }

        for(int i = 1; i<N+1; i++){
            if (i%2 == 1){
                // 홀수면
                for(int j = 0;j<N;j++){
                    System.out.print(array[j]);
                }
            } else {
                for(int j = N-1; j>=0; j--){
                    System.out.print(array[j]);
                }
            }

            System.out.println();
        }
    }
}