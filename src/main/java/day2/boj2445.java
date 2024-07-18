package day2;


/*
문제
=============================================
입력된 N을 기준으로  2×N-1번째 줄까지 차례대로 별을 출력
---------------------------------------------
예시 및 규칙
=============================================
>> N =5
*        *  i=1 >> | * i개 /black N-i개 /black N-i개 /* i개 |
**      **
***    ***
****  ****      >>(N-1)   (N-1)
**********       >> N*2
****  ****
***    ***
**      **
*        *
--------------------------------------------


 */


import java.util.Scanner;
import java.util.stream.IntStream;

public class boj2445 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        IntStream.range(1, N)
                .forEach(i -> System.out.println("*".repeat(i) + " ".repeat(N-i) + " ".repeat(N-i)+ "*".repeat(i)));

        System.out.println("*".repeat(2*N));

        //IntStream.range(N, 1)  -> range 는 항상 오름차순 >> python과 다름
        //        .forEach(i -> System.out.println("*".repeat(i) + " ".repeat(N-i) + " ".repeat(N-i)+ "*".repeat(i)));

        IntStream.iterate(N-1, i -> i-1 ) // IntStream.iterate(seed, f) > seed : 스트림의 첫번째 요소, f : 다음 요소 생성하는 함수 Ex) i-1 현재 값에서 1뺀다
                .limit(N-1) //IntStream.iterate(seed, f)는 무한스트림 > 제한 요소 필요
                .forEach(i -> System.out.println("*".repeat(i) + " ".repeat(N-i) + " ".repeat(N-i)+ "*".repeat(i)));
    }
}