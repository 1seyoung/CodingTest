package day1;

/*
--------------------------------------------------------------------
문제
====================================================================
(A+B)%C는 ((A%C) + (B%C))%C 와 같을까?

(A×B)%C는 ((A%C) × (B%C))%C 와 같을까?

세 수 A, B, C가 주어졌을 때, 위의 네 가지 값을 구하는 프로그램을 작성하시오.

입력 >> 숫자 3개 (A, B, C), 출력 >> (A+B)%C , ((A%C) + (B%C))%C,  (A×B)%C,  ((A%C) × (B%C))%C > 한줄에 하나
--------------------------------------------------------------------
 로직
====================================================================
숫자를 받고 하나 계산하고 출력 다음줄 출력 다음줄 출력...


 */

import java.util.Scanner;

public class boj10430 {
    public static void main(String[] arg){

        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        System.out.println((A+B)%C );
        System.out.println(((A%C) + (B%C))%C );
        System.out.println( (A*B)%C);
        System.out.println(  ((A%C) * (B%C))%C);

    }
}
