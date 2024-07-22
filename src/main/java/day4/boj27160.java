package day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class boj27160 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //첫 입력 T로 설정 ->
        int T = Integer.parseInt(br.readLine().trim());

        Map<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().trim().split("\\s+"); // 공백을 기준으로 분리
            String key = input[0];
            int value = Integer.parseInt(input[1]);
            map.put(key, map.getOrDefault(key, 0) + value); //누적합

        }

        boolean found = false;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 5) {
                found = true;
            }
        }
        if (found){
            System.out.print("YES");
        }
        else if(!found){
            System.out.print("NO");
        }

    }
}
