package week2.day4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class no1_boj11478 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();

        Set<String> substring = new HashSet<>();

        // 모든 부분 문자열을 추출하여 HashSet에 추가 -> String Substring 으로 부분 문자열 만들고 -> HashSet으로 중복제거
        for (int i = 0; i < S.length(); i++) {
            for (int j = i + 1; j <= S.length(); j++) {
                substring.add(S.substring(i, j));
            }
        }

        // 서로 다른 부분 문자열의 개수 출력
        System.out.println(substring.size());
    }
}

