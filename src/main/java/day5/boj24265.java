package day5;

import java.util.Scanner;

public class boj24265 {
    static  long code1count ;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        code1count = 0;

        /*
        MenOfPassion(A[], n) {
            sum <- 0;
            for i <- 1 to n - 1
                for j <- i + 1 to n
                    sum <- sum + A[i] × A[j]; # 코드1
            return sum;
            }
            첫번째 for 문 -> i가 1에서부터 n-1까지 반복
            두번째 for 문 -> j가 i+1 부터 n까지 반복
            ex) i = 1, j : 2-> n // i=2, j 3-> n // ... // i = n-1 , j : n-> n   ===> i = n-1일 때 j = 1번 반복 --------> j는 i에 대해 n-i 번 반복


            i=1 - > n-1 sum(n-i) (---> 시그마 계산 수행 ) ------> n(n-1)/2




         */
        code1count = (long) N * (N-1) /2;  // (long) -> cast ...?

        // 다항수 최고차항 차수 2
        System.out.println(code1count);
        System.out.println(2);




    }
}
