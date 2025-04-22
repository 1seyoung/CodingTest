import java.util.*;

public class Main {
    static int[] buildings; // 방문 순서대로 빌딩 번호를 저장하는 배열
    static List<List<Integer>> levels; // 각 레벨별 빌딩 번호를 저장하는 리스트
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt(); // 1. 깊이 K 입력
        int size = (1 << K) - 1; // 2. 노드 개수 계산 2^K - 1
        buildings = new int[size]; // 3. 빌딩 번호 배열 초기화
        
        // 4. 빌딩 번호 입력
        for (int i = 0; i < size; i++) {
            buildings[i] = scanner.nextInt();
        }
        
        // 5. 레벨별 빌딩 번호를 저장할 리스트 초기화
        levels = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            levels.add(new ArrayList<>());
        }
        
        // 6. 중위 순회 결과를 기반으로 트리 구성
        constructTree(0, size - 1, 0);
        
        // 7. 각 레벨별 빌딩 번호 출력
        for (List<Integer> level : levels) {
            for (int num : level) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    
    // 트리 구성 함수. 중위 순회 결과를 기반으로 트리 재구성
    static void constructTree(int left, int right, int depth) {
        if (left > right) return; // 6-1. 종료 조건: 구간이 비었을 경우
        
        int mid = (left + right) / 2; // 6-2. 중간 노드 찾기 (현재 루트 노드)
        levels.get(depth).add(buildings[mid]); // 6-3. 현재 깊이에 해당 빌딩 번호 저장
        
        // 6-4. 왼쪽 서브트리 구성 (현재 루트의 왼쪽 부분)
        constructTree(left, mid - 1, depth + 1);
        
        // 6-5. 오른쪽 서브트리 구성 (현재 루트의 오른쪽 부분)
        constructTree(mid + 1, right, depth + 1);
    }
}
