package week2.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class boj9933 {
    public static void main(String[] args) throws IOException {
        /*
        - 모든 단어의 길이 홀수
        - 한 줄에 단어 하나
        - 목록에는 비밀번호도 있고
        - 비밀 번호를 뒤집어 쓴 문자열도 있다.
        - 역순/ 원본 모두 비밀 번호로 가능해
        - 입력 : 단어 개 수 / 출력 : 비밀번호 길이, 가운 데 글자 출력
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Map<String,String> map = new HashMap<>();

        String word;
        String reverseWord;
        String password = null;
        int mid = 0;

        while (N-->0){
            word = br.readLine();
            reverseWord = new StringBuilder(word).reverse().toString();
            if (map.containsKey(reverseWord)){
                password = word;
            }
            if(word.equals(reverseWord)){
                password = word;
            }
            map.put(word, reverseWord);
        }
        if (password != null) {
            mid = password.length() / 2 +1;

        }

        System.out.println(password.length()+ " "+ password.charAt(mid-1));
    }
}
