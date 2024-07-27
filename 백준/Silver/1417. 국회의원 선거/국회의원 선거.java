import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCandidates = scanner.nextInt();  // 후보의 수
        int dasomVotes = scanner.nextInt();  // 다솜이의 득표 수

        // 다솜이 혼자 후보인 경우, 매수할 필요가 없으므로 0을 출력하고 종료
        if (numberOfCandidates == 1) {
            System.out.println(0);
            return;
        }

        // 다른 후보들의 득표수를 저장할 최대 힙
        PriorityQueue<Integer> voteHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i < numberOfCandidates; i++) {
            voteHeap.add(scanner.nextInt());
        }

        // 매수한 사람의 수 계산
        int bribes = calculateBribes(dasomVotes, voteHeap);

        // 매수한 사람의 수 출력
        System.out.println(bribes);
    }

    private static int calculateBribes(int dasomVotes, PriorityQueue<Integer> voteHeap) {
        int bribes = 0;

        // 계속해서 다솜이의 득표수가 다른 후보들보다 많아질 때까지 반복
        while (!voteHeap.isEmpty() && dasomVotes <= voteHeap.peek()) {
            int highestVotes = voteHeap.poll();
            voteHeap.add(highestVotes - 1);
            dasomVotes++;
            bribes++;
        }

        return bribes;
    }
}
