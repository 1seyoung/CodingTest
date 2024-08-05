package week1.day1;
/*
문제
물건은 6자리의 고유번호 가짐
처음 5자리 > 00000 ~ 99999
마지막 자리  > 검증 수 > 5개 숫자를 제곱한 수의 합 %10 (나머지)

ex) 04256 > 0+16+4+25+36 = 81 을 10으로 나눈 나머지인 1 > 검증수 1 >> 042561
입력 숫자 5개(5자리수)
출력 숫자 1개(검증수)

=================================================
로직
-------------------------------------------------
숫자 공백 기준으로 5개 입력 받고 계산하고 출력


=================================================
개선 방향
-------------------------------------------------
입력 부분 > 반복문 사용해서 개선가능할 듯함
*/

import java.util.Scanner;


public class boj2475 {
    public static void main(String[] arg){

        Scanner scanner = new Scanner(System.in);
        int S1 = scanner.nextInt();
        int S2 = scanner.nextInt();
        int S3 = scanner.nextInt();
        int S4 = scanner.nextInt();
        int S5 = scanner.nextInt();

        int verification_num = 0;

        verification_num = (S1*S1 +S2*S2 + S3*S3 + S4*S4 + S5*S5 ) % 10;

        System.out.println(verification_num);



    }
}
