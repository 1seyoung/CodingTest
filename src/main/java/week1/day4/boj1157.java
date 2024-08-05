package week1.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class boj1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        sb.append(br.readLine().trim().toUpperCase());
        String[] str = sb.toString().split(""); //\\s+는 하나 이상의 공백 문자를 의미

        Map<String, Integer> map = new LinkedHashMap<>();
        List<String> max_string = new ArrayList<>();

        int length = str.length;
        String current_string = "";
        int i = 0;
        int max = 0;

        while (i < length) {
            current_string = str[i++];
            if(!map.containsKey(current_string)) {
                map.put(current_string, 1);
            } else {
                map.put(current_string, map.get(current_string) + 1);
            }
            int currentValue = map.get(current_string);

            if (max < currentValue){

                    max = currentValue;

                }
            }




        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                max_string.add(entry.getKey());
            }
        }

        if (max_string.size() > 1){
            System.out.print("?");
        } else {
            System.out .print(max_string.get(0));
        }

    }
}
