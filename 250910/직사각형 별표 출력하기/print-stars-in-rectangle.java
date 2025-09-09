import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        // N 행 M 열

        for(int i = 0; i <N;i++){
            for(int j=0; j<M; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}