package day2;
/*
문제 링크 : https://www.acmicpc.net/problem/2438
------------------------------------------------
로직
================================================
scanner 로 N 입력 받기 -> int N

N줄 출력
* 1개  -->
* 2개
...
* N-1개
* N개

 */

import java.util.Scanner;
import java.util.stream.IntStream;

public class boj2438 {
    public static void main (String[] arg){

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();


        IntStream.rangeClosed(1,N)
                .forEach(i -> System.out.println("*".repeat(i)));
        //String.repeat(int count) : 주어진 문자열을 count 횟수만큼 반복하여 새로운 문자열 반환
        //알아두면 좋을 문자열 함수 : String.isBlank() /String.lines()/String.strip()/String.transform(Function<String, R> f)
    }
}
