package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        String[] str = br.readLine().split(" ");


        String reversed1  = new StringBuffer(str[0]).reverse().toString();
        String reversed2  = new StringBuffer(str[1]).reverse().toString();

        int reversed1_int = Integer.parseInt(reversed1);
        int reversed2_int = Integer.parseInt(reversed2);

        if (reversed1_int > reversed2_int) {
            System.out.print(reversed1_int);
        } else {
            System.out.print(reversed2_int);
        }

    }
}
