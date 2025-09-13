import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        int count = 1;
        // N+M-1 반복 
        for(int i = 0; i<m ; i++){

            int startN =0;
            int startM = i;
            while(startN < n && startM >= 0){
                arr[startN][startM] = count;
                startN += 1 ;
                startM -= 1;
                count += 1;
            }
        }

        for(int i = 1; i<=n-1;i++){
            int startN = i;
            int startM = m-1;
            while(startN < n && startM >= 0){
                arr[startN][startM] = count;
                startN += 1;
                startM -= 1;
                count += 1;
            }
        }


        for(int i = 0; i <n;i++){
            for(int j =0; j <m; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        
    }
}