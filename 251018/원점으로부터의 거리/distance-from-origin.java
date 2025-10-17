import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Coordinate[] coordinates = new Coordinate[n];

        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            coordinates[i] = new Coordinate(x,y,i+1);
        }

        Arrays.sort(coordinates);
        for(int i = 0; i <n; i++){
            System.out.println(coordinates[i].order);
        }
        // Please write your code here.
    }
}

class Coordinate implements Comparable<Coordinate>{
    int order;
    int x;
    int y;

    public Coordinate(int x, int y, int order){
        this.order = order;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Coordinate e){
    int dist1 = Math.abs(this.x) + Math.abs(this.y);
    int dist2 = Math.abs(e.x) + Math.abs(e.y);

    if (dist1 != dist2) return dist1 - dist2;
    return this.order - e.order; // 두 값을 비교해서 누가 더 앞에 와야하냐? 결과가 음수냐 0? + 에 다라 정렬 순서 판단()
    }
}