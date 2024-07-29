
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();


        String schoolName;
        Integer drink;
        String[] str;

        int T = Integer.parseInt(br.readLine().trim());
        String[] result = new String[T];
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < N; i++) {
                str = br.readLine().split(" ");
                schoolName = str[0];
                drink = Integer.parseInt(str[1]);

                map.put(schoolName, map.getOrDefault(schoolName, 0) + drink);
            }
            // 최대 값을 가진 키 찾기
            String maxKey = null;
            int maxValue = Integer.MIN_VALUE; // 초기 최대 값을 Integer의 최소 값으로 설정 -> gpt 가 그렇다네요

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() > maxValue) {
                    maxValue = entry.getValue();
                    maxKey = entry.getKey();
                }


            }
            result[T] = maxKey;
            map.clear();
        }
        //for (int i = 0; i < T; i++) {
        //    System.out.println(result[i]);
        //}
        for (String res : result) {
            System.out.println(res);
        }


    }
}