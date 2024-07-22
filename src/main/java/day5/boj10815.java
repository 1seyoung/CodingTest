package day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class boj10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. N값 읽기
        int N  = Integer.parseInt(br.readLine());

        //2. readline으로 NlistStr을 읽어 공백으로 분리
        String[] NlistStr = br.readLine().trim().split(" ");
        // 3. NlistStr 배열의 각 문자열을 정수로 변환하여 Set에 저장
        Set<Integer> nSet = Arrays.stream(NlistStr) //3-1.  NlistStr 배열을 스트림으로 변환
                .map(Integer::parseInt) // 3-2. 각 문자열을 Integer로 변환
                .collect(Collectors.toSet()); // 3-3. 변환된 정수를 Set으로 수집 (중복된 값 제거) ? 중복이 되는 상황에는 뭘쓰지

        //4. M 입력
        int M = Integer.parseInt(br.readLine());
        //5. Mlist는 왜 배열에 저장했나 -> 출력할때 순서를 유지해야하기 때문
        String[] MlistStr = br.readLine().trim().split(" ");
        int[] Mlist = Arrays.stream(MlistStr)
                .mapToInt(Integer::parseInt)
                .toArray();

        //6. 존재 여부에 관한 정보 저장할 리스트
        int[] Check = new int[M];

        // 7. Mlist의 각 숫자가 Nlist에 포함되어 있는지 확인  ? binary seach 함수를 쓰는게 더 좋은지? >> 좋다. >> 보통 구현해서 쓰기 >> collection 불러와서 쓰려고 하지말기.
        for (int i =0 ;i<M;i++){
            if (nSet.contains(Mlist[i])) {
                Check[i] = 1;
            }
            if(!nSet.contains(Mlist[i])){
                Check[i] = 0;
            }

            }
        for (int i : Check) {
            System.out.print(i + " ");
        }
        }

    }

