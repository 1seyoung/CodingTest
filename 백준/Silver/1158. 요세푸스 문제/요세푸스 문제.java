
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder result = new StringBuilder();

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    Queue<Integer> queue = new LinkedList<>();

    for(int i = 1; i <= N; i++) {
      queue.add(i);
    }

    result.append("<");

    while (queue.size() != 1) {
      for (int i = 0; i < K - 1; i++) {
        queue.add(queue.poll());
      }
      result.append(queue.poll()).append(", ");
    }
    result.append(queue.poll()).append(">");

    System.out.println(result);
  }
}
