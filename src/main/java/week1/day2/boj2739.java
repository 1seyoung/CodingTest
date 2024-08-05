package week1.day2;


import java.util.Scanner;
import java.util.stream.IntStream;

/*
과제 1번
문제 링크 : https://www.acmicpc.net/problem/2739

문제 설명 : N을 입력 받은 뒤, 구구단 N단을 출력

로직 ver1
숫자 N 입력받기 --> scanner
반복문 N * (1~9) 한 줄 씩 출력
출력 형식 N + "*" + i + "=" + N*i

로직 ver2
입력받기 N
IntStream이용해 반복 진행
 */
public class boj2739 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        IntStream.rangeClosed(1,9) //IntStream.rangeClosed 1부터 9까지의 숫자를 포함하는 스트림을 생성
                .forEach(i -> System.out.println(N + " * " + i + " = " + (N * i)));


    }
}
