package day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class boj10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N  = Integer.parseInt(br.readLine());
        String[] NlistStr = br.readLine().trim().split(" ");

        //NlistStr의 숫자, 빈도를 저장할 HashMap 생성
        Map<Integer,Integer> NMap = new HashMap<>();
        for (String n : NlistStr){
            int num = Integer.parseInt(n);
            NMap.put(num,NMap.getOrDefault(num,0) +1);
        }

        int M = Integer.parseInt(br.readLine());
        String[] MlistStr = br.readLine().trim().split(" ");
        int[] Mlist = Arrays.stream(MlistStr)
                .mapToInt(Integer::parseInt)
                .toArray();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            result.append(NMap.getOrDefault(Mlist[i], 0)).append(' ');
        }
        System.out.println(result.toString().trim());

        /* ---> 시간 초과
        int[] Check = new int[M];


        for (int i =0 ;i<M;i++){
            Check[i] = NMap.getOrDefault(Mlist[i],0);

        }
        for (int count : Check) {
            System.out.print(count + " ");
        }

         */
    } //정말 대기업에서는 맞춘다. >> 게임기업에서는 마우스 못쓰게하기... >> 훈련해봐요 // 일단 푸는거...! // 가능하면 제안된거를 쓰는게 좋긴한데 집착하지 말기 //


}
