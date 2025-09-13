import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int count = 1;
        int n = sc.nextInt();

        int[][] arr = new int[n][n];

        for(int i = 0 ; i < n;i++){
            for(int j = 0; j <n;j++){
                arr[i][j] = count;
                count+=1;
            }
        }

        for(int i = 0 ; i < n;i++){
            for(int j = 0; j <n;j++){

                System.out.print(arr[j][i]+" ");
            }
            System.out.println();
        }     
        
    }
}

