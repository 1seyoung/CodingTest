import java.util.*;

class Solution {
    private static final HashMap<Character, int[]> location = new HashMap<>();
    
    static {
        location.put('U', new int[]{0, 1});
        location.put('D', new int[]{0, -1});
        location.put('R', new int[]{1, 0});
        location.put('L', new int[]{-1, 0});
    }
    
    public boolean isValid(int x, int y) {
        return 0<= x && x <11 && 0<= y && y <11;
    }
    
    public int solution(String dirs) {
        
        //편하게 생각하기 위해 시작점을 5,5 로 생각해
        int x = 5;
        int y = 5;
        
        //중복을 더하지말래 -> Set
        HashSet<String> answer = new HashSet<>();
        
        // 반복하기 얼마나? 명령어 숫자만큼
        
        for(int i =0; i < dirs.length() ; i++) {
            int[] cmd = location.get(dirs.charAt(i));
            int nx = x + cmd[0];
            int ny = y + cmd[1];
            
            // 범위 내인지 확익할려면-> 함수로 만들기 isValid
            if(!isValid(nx, ny)) continue;
            
            //처음 걸어본 길만 기록해 (두번째는 x 일단 양방향을 저장해둔다 왜냐면 나중에 반대로 왔을때 중복인걸 알아채기 위해서
            answer.add(x +" "+y+" "+nx +" "+ny);
            answer.add(nx +" "+ny+" "+x +" "+y);
            
            x = nx;
            y = ny;// 새로 업데이트
        }
        
        return answer.size()/2;
    }
}