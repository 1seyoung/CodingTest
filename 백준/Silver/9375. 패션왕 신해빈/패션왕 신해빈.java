import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();  // 테스트 케이스 수
        while (t-- > 0) {
            int n = sc.nextInt();  // 각 테스트 케이스의 의상 수
            HashMap<String, Integer> clothes = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String name = sc.next();  // 의상 이름
                String type = sc.next();  // 의상 종류

                clothes.put(type, clothes.getOrDefault(type, 0) + 1);
            }

            int result = 1;
            for (int count : clothes.values()) {
                result *= (count + 1);
            }

            System.out.println(result - 1);  // 알몸인 경우를 제외
        }

        sc.close();
    }
}
