import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        int sum = 0;

        // 아홉 난쟁이의 키를 입력받고 합을 계산
        for (int i = 0; i < 9; i++) {
            int height = Integer.parseInt(br.readLine().trim());
            list.add(height);
            sum += height;
        }

        int fake1 = -1, fake2 = -1;

        // 두 가짜 난쟁이 찾기
        outer: for (int j = 0; j < 8; j++) {
            for (int k = j + 1; k < 9; k++) {
                if ((sum - list.get(j) - list.get(k)) == 100) {
                    fake1 = j;
                    fake2 = k;
                    break outer;
                }
            }
        }

        // 가짜 난쟁이 제거 (인덱스 주의: fake1 > fake2 인 경우를 대비하여 큰 인덱스를 먼저 제거)
        if (fake1 > fake2) {
            list.remove(fake1);
            list.remove(fake2);
        } else {
            list.remove(fake2);
            list.remove(fake1);
        }

        // 오름차순 정렬
        Collections.sort(list);

        // 결과 출력
        for (int height : list) {
            System.out.println(height);
        }
    }
}
