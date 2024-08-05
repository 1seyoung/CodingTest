package week3.day1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class no1_boj1026 {
    public static void main(String[] args) {
        //목표 : S의 값이 최소로 나오게 배열 A를 정렬하기 그리고 S 출력

        /*
        1. N 입력받기
        2. 배열 A 입력받기
        3. 배열 B 입력받기


        4. S가 최소가 될 수 있게 A를 정렬
        4-1. B의 큰 순서를 알아내기(리스트에 순서 인덱스 저장)
        4-2 순서에 맞게 A 배열 섞기
        5. S 계산

         */
        Scanner sc = new Scanner(System.in);
        //1. N 입력받기
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        // 4-1 B의 크기 순서를 저장하는 인덱스 Array
        Integer[] indexArray = new Integer[N];
        int S=0;

        //2. 배열 A 입력받기
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        // 3. 배열 B 입력받기
        for (int i = 0; i < N; i++) {
            B[i] = sc.nextInt();
        }
        sc.close();
        //4. A 정렬
        //가장 작은 S를 구하는 쉬운 방법 A 오름차순 / B 내림차순 정렬 해서 곱하기
        //근데 조건에서 B를 건들지 말라니깐 다른 방법을 사용

        //A를 오름차순으로 정렬
        Arrays.sort(A);

        // 배열 B의 인덱스를 큰 순서대로 정렬하기 위한 인덱스 배열 생성
        for (int i = 0; i < N; i++) {
            indexArray[i] = i;
        }

        //배열 B의 값을 기준으로 인덱스 배열 내림차순 정렬
        Arrays.sort(indexArray,new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(B[o2], B[o1]); // B[o2]가 B[o1]보다 크면 양수, 작으면 음수를 반환
            }
        });

        //5. 최소 S값 계산
        for (int i = 0; i < N; i++) {
            S +=A[i] *B[indexArray[i]];
        }


        System.out.println(S);







    }
}
