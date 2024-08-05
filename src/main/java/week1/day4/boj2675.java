package week1.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class boj2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();



        int T  = Integer.parseInt(br.readLine());

        while(T > 0){

            String[] str = br.readLine().split(" ");
            int repeat = Integer.parseInt(str[0]);
            String string = str[1];


            for (byte val : string.getBytes()) {
                for (int j = 0; j < repeat; j++) {
                    sb.append((char) val);
                }
            }
            sb.append("\n");

            T--;

        }
        System.out.print(sb.toString());

    }
}
