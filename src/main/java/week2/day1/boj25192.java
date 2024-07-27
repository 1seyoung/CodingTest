package week2.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj25192 {
    public static void main(String[] args) throws IOException {
        /*
        ENTER는 새로운 사람이 채팅방에 입장했음을 나타낸다. 그 외는 채팅을 입력한 유저의 닉네임을 나타낸다. 닉네임은 숫자 또는 영문 대소문자로 구성되어 있다.

        "새로운 사람이 입장한 이후 처음 채팅을 입력하는 사람은 반드시 곰곰티콘으로 인사를 한다". 그 외의 기록은 곰곰티콘을 쓰지 않은 평범한 채팅 기록이다.

        채팅 기록 중 곰곰티콘이 사용된 횟수를 구해보자!
         */

        //1. 첫 번째 줄에는 채팅방의 기록 수를 나타내는 정수 N 이 주어진다

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N  = Integer.parseInt(br.readLine());

        int temp=0;

        String chat = "";
        Set<String> gomgom = new HashSet<>();

        while (N-- > 0) {
            chat = br.readLine();

            if(chat.equals("ENTER")){

                gomgom.clear();
                continue;
            }

            if (!gomgom.contains(chat)) {
                temp ++;
                gomgom.add(chat);
            }
            else{
                continue;
            }
            }
        System.out.print(temp);

        }


}
