import java.util.*;
class Solution {
    public int[][] solution(int[][] datas, String ext, int val_ext, String sort_by) {        
        
        List<List<Integer>> slice = new ArrayList<>();
        
        int filterIdx = returnIdx(ext);
        
        for(int[] data : datas){
            if(data[filterIdx] < val_ext){
                List<Integer> row = new ArrayList<>();
                for(int n : data){
                    row.add(n);
                }
                slice.add(row);
            }
        }
        
        
        int sortIdx = returnIdx(sort_by);
        
        // 정렬
        for(int i = 0; i < slice.size();i++){
            for(int j = i+1; j < slice.size();j++){
                if(slice.get(i).get(sortIdx) > slice.get(j).get(sortIdx)){
                    List<Integer> temp = slice.get(i);
                    slice.set(i,slice.get(j));
                    slice.set(j, temp);
                }
            }
        }
        
        int size = slice.size();
        int[][] answer = new int[size][4];
        
        for(int i = 0; i < size; i++){
            List<Integer> row = slice.get(i);
            for(int j = 0; j < 4; j++){
                answer[i][j] = row.get(j);
            }
        }
        
        return answer;
    }
    
    public int returnIdx(String s) {
        if(s.equals("code")){
            return 0;
        }
        if(s.equals("date")){
            return 1;
        }
        if(s.equals("maximum")){
            return 2;
        }
        if(s.equals("remain")){
            return 3;
        }
        return -1;
    }
}