package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1152 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sb.append(br.readLine().trim());
        String[] str = sb.toString().split("\\s+"); //\\s+는 하나 이상의 공백 문자를 의미

        if (str.length == 1 && str[0].isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(str.length);
        }
    }
}
