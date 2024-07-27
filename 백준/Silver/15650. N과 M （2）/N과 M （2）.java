import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        scanner.close();
        int[] sequence = new int[M];

        findMNMs(N, M, 0,1, sequence);

    }
    //Backtracking
    private static void findMNMs ( int N, int M, int depth, int start,int[] sequence){
        if (depth == M) {
            for (int i = 0; i < M; i++){
                System.out.print(sequence[i] + " ");

            }
            System.out.println();
            return;
        }
        for (int i = start; i <= N; i++) {
            sequence[depth] = i;
            findMNMs(N, M, depth + 1, i+1, sequence);

            }
        }


    }

