package day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class boj15649 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        /*
        1 ~ N 자연수 중 중복 없이 M개 고르기 -> 수열? --> 예시 보면 순열

        M * (M -1) * ... * 2 * 1개 나온다. ->

        순열 -> 순서 있음

        수열은 사전 순으로 증가하는 순서로 출력해야 한다.
         */

        BufferedReader br   = new BufferedReader(new InputStreamReader(System.in));


        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        //계속 뽑아... 뽑고 뽑고 뽑고 >> 재귀..? --> 힌트 : 백트래킹 : 해를 찾아가는 도중, 지금 경로가 해가 될 것 같지 않으면 그 경로를 더 이상 가지않고 되돌아간다.
        // = 가지치기..? 깊이.. 맨 아래 도달하면 종료되게
        List<int[]> list = new ArrayList<>();

        pruning(M, 0, list,N); // 맨 마지막, 현재 위치(시작 위치)


    }

    public static void pruning(int depth, int index, List<int[]> output, int n){
        //맨 아래 도달하면 종료 -> 맨 아래 -> M
        if (depth == index){
            //도달하면 만든거 출력해 -> output
            //System.out.println(output);
            for (int i = 0; i < depth; i++){
                //System.out.println(output.get(i));
                sb.append(output.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0;i<n;i++){
            //여기서 Output 저장...?
            //temp[index] 에 i를 저장..
            // ...?

        }
    }
}

// 조건 확인 N -> 두 자리 정해요
//sc.close(); -> 하는걸 좋다. 메모리 잡아먹는다 닫아줘야 메모리에서 사라짐
//