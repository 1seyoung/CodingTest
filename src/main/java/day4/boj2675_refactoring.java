package day4;
/*
https://st-lab.tistory.com/63  참고 링크
 */
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class boj2675_refactoring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        Map<Integer, String> map = new LinkedHashMap<>();
        while (T > 0) {
            int repeat = scanner.nextInt();
            String string = scanner.next();
            map.put(repeat, string);
            T--;
        }


        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String str = entry.getValue();


            StringBuilder result = new StringBuilder();
            for (char ch : str.toCharArray()) {
                result.append(String.valueOf(ch).repeat(key));
            }


            System.out.println(result.toString());
        }

        scanner.close();
    }
}
