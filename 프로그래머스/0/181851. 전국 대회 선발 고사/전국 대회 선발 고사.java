import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        List<int[]> list = new ArrayList<>();
        // 등수, 번호
        int answer = 0;
        int n = attendance.length;
        for(int i = 0; i < n ; i ++){
            if(attendance[i]){
                list.add(new int[]{rank[i],i});
            }
        }
        
        list.sort(Comparator.comparingInt(a -> a[0]));
        int i = list.get(0)[1];
        int j = list.get(1)[1];
        int k = list.get(2)[1];

        return 10000 * i + 100 * j + k;    }
}