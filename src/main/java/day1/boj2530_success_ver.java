package day1;


import java.util.Scanner;

/*
문제 링크 : https://www.acmicpc.net/problem/2530

--------------------------------------------------------------------
문제
====================================================================
오븐에 달린 시계
- 현재 시간 나옴 (시분초)
- 오븐 구이에 필요한 시간 줌(초)
>> 끝나는 시간 출력 (시 분 초)
 */
import java.util.Scanner;

public class boj2530_success_ver {
    public static void main(String[] args) {

        // 입력받기
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt(); // 시
        int B = scanner.nextInt(); // 분
        int C = scanner.nextInt(); // 초
        int D = scanner.nextInt(); // 요리하는데 필요한 시간 (초)

        //로직
        int totalSeconds = A * 3600 + B * 60 + C + D; // 전체 시간을 초로 환산 +D

        int newH = (totalSeconds / 3600) % 24; // 시간을 구하고 24로 나눈 나머지
        int newM = (totalSeconds % 3600) / 60; // 남은 초에서 분을 구함
        int newS = totalSeconds % 60; // 남은 초에서 초를 구함


        System.out.println(newH + " " + newM + " " + newS);

    }
}
