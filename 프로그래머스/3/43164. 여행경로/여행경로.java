import java.util.*;

class Solution {

    boolean[] used;
    List<String> path = new ArrayList<>();
    List<String> answer = new ArrayList<>();
    boolean finished = false;

    public String[] solution(String[][] tickets) {

        // 1) "FROMTO" 문자열로 변환
        String[] arr = new String[tickets.length];
        for (int i = 0; i < tickets.length; i++) {
            arr[i] = tickets[i][0] + tickets[i][1];
        }

        // 2) 문자열 정렬
        Arrays.sort(arr); // 사전순 정렬

        // 3) 다시 2차원 배열로 복구
        String[][] sorted = new String[tickets.length][2];
        for (int i = 0; i < arr.length; i++) {
            sorted[i][0] = arr[i].substring(0, 3); // FROM
            sorted[i][1] = arr[i].substring(3);   // TO
        }

        used = new boolean[sorted.length];

        // 4) 경로 시작은 ICN
        path.add("ICN");

        dfs("ICN", sorted, 0);

        return answer.toArray(new String[0]);
    }

    void dfs(String cur, String[][] tickets, int count) {

        if (finished) return;

        // 모든 티켓 사용 완료
        if (count == tickets.length) {
            answer = new ArrayList<>(path);
            finished = true;
            return;
        }

        // 문자열 정렬된 티켓에서, 현재 공항에서 출발하는 티켓만 사용
        for (int i = 0; i < tickets.length; i++) {

            if (used[i]) continue;

            if (tickets[i][0].equals(cur)) {
                used[i] = true;
                path.add(tickets[i][1]);

                dfs(tickets[i][1], tickets, count + 1);

                if (finished) return;

                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}