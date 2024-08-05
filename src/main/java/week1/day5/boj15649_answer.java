package week1.day5;

/*
import java.util.List;
import java.util.Scanner;
public class boj15649_answer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        scanner.close();
        //ver2
        boolean[] used = new boolean[N + 1];
        int[] sequence = new int[M];

        findNNMs(N,M, depth,sequence,used);

        private static void findMNMs(int N, int M, int depth,int[] sequednce, booleanp[] used){
            if(depth==M){
                for (int i =0;,i < M, i++){
                    System.out.println(sequednce[i] + " ");

                }

                System.out.println();
                return;
            }

            for (int i =1 , i <=N; i++){
                if(used[i]){
                    used[i] = true;
                    sequence[depth] = i;
                    findMNMs(N,M,depth+1,sequence,used);
                    used[i] = false
                }
            }

        /*private static void findNNMs(int N, int M){
            List NList = [];

            for(int i = 0; i < N; i++){
                NList.append(i);
            }

            Nlist -> 2개를 가져오는데 순서가 중요하다(순서 상관있게 M개를 가져오고 그거 그대로 print 찍어주기. )

            ver1*/
            //재귀를 안써도 된다.
            // 근데 쓸꺼면 ?
            // depth도 있어야하고.

//        }
//    }
//}
