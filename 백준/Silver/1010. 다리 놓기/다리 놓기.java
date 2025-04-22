import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T>0) {
            int N = sc.nextInt();
            int M = sc.nextInt();


            long result = calculator(M, N);

            System.out.println(result);

            T--;
        }

    }

    static long calculator(int M, int N) {
        long result = 1;
        for(int i = 0; i < N; i++) {
            result = result * (M - i) / (i + 1);
        }
        return result;
    }
}