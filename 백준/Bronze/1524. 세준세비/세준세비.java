import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 테스트 케이스 개수
        scanner.nextLine(); // 개행 문자 소비

        while (T-- > 0) {
            int N = scanner.nextInt(); // 세준이 병사의 수
            int M = scanner.nextInt(); // 세비 병사의 수
            scanner.nextLine(); // 개행 문자 소비

            // 세준이 병사들
            int[] sPower = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();

            // 세비 병사들
            int[] bPower = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();

            // 전투 횟수 -> 제거 횟수
            int sIndex = 0;
            int bIndex = 0;

            // 전투 반복
            while (sIndex < N && bIndex < M) {
                if (sPower[sIndex] < bPower[bIndex]) {
                    // 세준이의 병사가 더 약하면 세준이 병사가 죽음
                    sIndex++;
                } else if (sPower[sIndex] > bPower[bIndex]) {
                    // 세비의 병사가 더 약하면 세비 병사가 죽음
                    bIndex++;
                } else {
                    // 제일 약한 병사가 양쪽에 모두 있는 경우 세비의 병사가 죽음
                    bIndex++;
                }
            }

            // 승자 결정
            if (sIndex < N) {
                // 세준이의 병사가 남아 있다면 세준이가 승리
                System.out.print("S");
            } else {
                // 그렇지 않으면 세비 승리
                System.out.print("B");
            }
            System.out.println();
        }

        scanner.close(); //리소스 해제 -> 메모리 신경쓰면서 코딩하기
    }
}
