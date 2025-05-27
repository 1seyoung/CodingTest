import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        HashMap<Integer, String> hash1 = new HashMap<>();
        HashMap<String, Integer> hash2 = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            hash1.put(i, name);
            hash2.put(name, i);
        }

        for (int i = 0; i < M; i++) {
            String query = br.readLine();

            if (isNumeric(query)) {
                int idx = Integer.parseInt(query);
                sb.append(hash1.get(idx)).append("\n");
            } else {
                sb.append(hash2.get(query)).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static boolean isNumeric(String str) {
        // 숫자인지 판별하는 함수
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}