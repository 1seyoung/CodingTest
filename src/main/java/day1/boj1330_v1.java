package day1;

/*
문제
A가 B보다 큰 경우에는 '>'를 출력한다.
A가 B보다 작은 경우에는 '<'를 출력한다.
A와 B가 같은 경우에는 '=='를 출력한다.
----------------------------------
로직
입력 : 정수 A B (공백으로 구분) ----> scanner
출력 :    A가 B보다 큰 경우에는 '>'를 출력한다. ------> if(A>B)
        A가 B보다 작은 경우에는 '<'를 출력한다.  -----else if(A<B)
        A와 B가 같은 경우에는 '=='를 출력한다. -----> else


*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class boj1330_v1 {
    public static void main(String[] arg) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        String[] parts = line.split(" ");

        int A = Integer.parseInt(parts[0]);
        int B = Integer.parseInt(parts[1]);


        if (A>B){
            System.out.println(">");
        }
        else if (A<B){
            System.out.println("<");
        }
        else {
            System.out.println("==");
        }

    }
}
