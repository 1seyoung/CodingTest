package week1.day1;


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

public class boj2530_fail_ver {
    public static void main(String[] args) {

        //입력받기
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();
        String[] firstParts = firstLine.split(" ");

        String secondLine = scanner.nextLine();
        String[] secondParts = secondLine.split(" ");

        int A = Integer.parseInt(firstParts[0]); //배열의 첫 번째 요소를 Integer.parseInt를 통해 문자열 > 정수 변환 수행
        int B = Integer.parseInt(firstParts[1]);
        int C = Integer.parseInt(firstParts[2]);

        int D = Integer.parseInt(secondParts[0]);


        //실제 로직
        //초를 분으로 변환(D)
        int s = D%60; // D를 초로 변환
        int m = D/60; // D를 분으로 변환

        //분을 시간으로
        int h = m/60; // m을 시간으로 변환
        m = m%60; // 나머지 분
        s+=C;
        if (s>=60){ // 초가 60을 넘으면
            m = m + s/60;
            s = s%60;

            m+= B;
            if (m >= 60){
                h = m/60+ h;
                 m = m%60;

                h+=A;
                 if (h >=24){
                     h = h%24;
                 }
            }

        }
        System.out.println(h+" "+m+" "+s);
    }

}
