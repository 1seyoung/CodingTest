
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    //1. 노드 개수 입력 N
    int n = sc.nextInt();

    //2. 각 노드의 부모노드 정보
    int[] parent = new int[n];

    // 자식 노드도 저장
    ArrayList<Integer>[] children = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      children[i] = new ArrayList<>();
    }

    //노드 연결
    for (int i = 0; i < n; i++) {
      parent[i] = sc.nextInt();
      if (parent[i] != -1) {
        children[parent[i]].add(i);
      }
    }

    //3. 지울 노드 번호
    int removeNode = sc.nextInt();

    // 4. 루트 노드 찾기 (부모가 없다면 (루트) ->  -1)
    int root = -1;

    for (int i = 0; i < n; i++) {
      if (parent[i] == -1) {
        root = i;
        break;
      }
    }

    // 5. 지울 노드가 루트인지 체크
    if (root == removeNode) {
      System.out.println(0);
      return;
    }

    // 6. 지울 노드 제거
    if (parent[removeNode] != -1) {
      children[parent[removeNode]].remove(Integer.valueOf(removeNode));
    }

    // 리프 노드 개수 계산
    int leafCount = countLeafNodes(children, root, removeNode);

    System.out.println(leafCount);
    sc.close();



  }

  private static int countLeafNodes(ArrayList<Integer>[] children, int root, int removeNode) {
    //지울 노드가 현재 노드인가?
    if (root == removeNode) {
      return 0;
    }

    // 자식이 없다면 리프 노드
    if (children[root].isEmpty()) {
      return 1;
    }

    int count = 0;
    boolean hasValidChild = false;


    for (int child : children[root]) {
      if (child != removeNode) {
        count += countLeafNodes(children, child, removeNode);
        hasValidChild = true;
      }
    }

    if (!hasValidChild && children[root].size() > 0 &&
        children[root].stream().allMatch(child -> child == removeNode)) {
      return 1;
    }

    return count;
  }
}
