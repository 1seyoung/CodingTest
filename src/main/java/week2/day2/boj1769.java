package week2.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1769 {
    public static void main(String[] args) throws IOException {
        /*
        문제 글 가독성 제로

        문제 새로 쓰기
        - 어떤 양의 정수 X가 주어졌을 때, 이 수가 3의 배수인지 확인하는 문제
        변환? : X의 각 자리 숫자를 더하여 새로운 수 Y 만들기 --> X가 1107이면, Y는 1 + 1 + 0 + 7 = 9
                    Y가 3, 6, 9 중 하나이면 X는 3의 배수
                    Y가 1, 2, 4, 5, 7, 8 중 하나이면 X는 3의 배수 x
        ex) 9875 - > 9 + 8 + 7 + 5 = 29 -> 2 + 9 = 11 -> 1 + 1 = 2 (한 자리 수 도달) 변환 과정 횟수 3
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split("");

        int length = str.length;
        int sum = 0;
        int count = 0;

        while (length > 1) {
            int[] intArray = new int[length]; // Int 로 형변환

            for (int i = 0; i < length; i++) {
                // 문자열 -> 숫자
                intArray[i] = Integer.parseInt(str[i]);
            }

            // 각 자리수 값 더하기
            sum = Arrays.stream(intArray).sum();
            count += 1;

            // 숫자 -> 문자열
            str = String.valueOf(sum).split("");
            length = str.length;
        }

        // 최종 값 업데이트
        if (length == 1) {
            sum = Integer.parseInt(str[0]);
        }

        int input = sum;

        System.out.println(count);
        if (input % 3 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}