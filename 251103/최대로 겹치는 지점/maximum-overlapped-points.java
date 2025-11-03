import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] block = new int[101];
        int max = 0;

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            for(int j = start; j <= end; j++){
                block[j] +=1;
                max = Math.max(max,block[j]);
            }

            
        }
        // Please write your code here.
        System.out.print(max);
    }
}