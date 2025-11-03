import java.util.*;
import java.io.*;
public class Main {
    static char[][] tile;       // 각 명령(line)마다 색칠 기록
    static char[] lastColor;    // 최종 타일 색상
    static int curIdx;          // 현재 위치 인덱스
    static int line;            // 현재 명령 번호
    static int offset;          // 좌표 기준점 (음수 방지용)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        offset = 200001;

        tile = new char[n][offset];
        lastColor  = new char[offset];

        curIdx = offset /2;
        line = 0;

        for(int i = 0; i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            coloringTile(x, dir);
        }

        int wCount = 0;
        int bCount = 0;
        int gCount = 0;

        // 각 칸별 최종 색상 통계
        for(int j = 0; j <offset; j++){
            int balckCnt = 0;
            int whiteCnt = 0;
            
            for(int i = 0; i < n ; i++){
                if(tile[i][j] == 'B') balckCnt++;
                if(tile[i][j] == 'W') whiteCnt++;
            }

            if(balckCnt >= 2 && whiteCnt >=2) {
                gCount++;
            }
            else{
                if (lastColor[j] =='W') wCount++;
                if (lastColor[j] == 'B') bCount++;

            }

        }
                System.out.println(wCount + " " + bCount + " " + gCount);

    }

    public static void coloringTile(int x , char dir){
        if(dir == 'R'){
            for(int i = curIdx; i < curIdx +x; i++){
                tile[line][i] = 'B';
                lastColor[i] = 'B';
            }

            if(x > 1) curIdx += x-1;

            line++;
        }

        if(dir =='L'){
            for(int i = curIdx; i > curIdx - x; i--){
                tile[line][i] = 'W';
                lastColor[i] = 'W';
            }
            if(x > 1) curIdx -= x-1;

            line++;
        }

        
    }
}