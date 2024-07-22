package day5;

import java.util.Scanner;

public class boj24267 {
    static  long code1count ;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        code1count = 0;


        /*
        MenOfPassion(A[], n) {
            sum <- 0;
            for i <- 1 to n - 2
                for j <- i + 1 to n - 1
                    for k <- j + 1 to n
                        sum <- sum + A[i] × A[j] × A[k]; # 코드1
            return sum;
            }

            i : 1 ~ n-2 ----  n-2
            j : i 기준 n-i -----n-i-1
            k  : j 기준   ------- n-j

            ... 오랜만에 시그마 계산해서 힘들었음.
            대충 계산하다보면 --> (n-2)(n-1)n/6
         */

        code1count = (long) (N-2) * (N-1) * N /6;
        System.out.println(code1count);
        System.out.println(3);
    }
}
