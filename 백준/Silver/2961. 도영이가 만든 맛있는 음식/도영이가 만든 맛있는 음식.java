

import java.util.Scanner;

/*
문제 분석
재료의 수 : N개
각 재료의 신맛 S / 쓴맛 B

요리의 신맛 : 각 재료의 신맛의 곱
요리의 쓴맛 : 각 재료의 쓴맛의 합

목표 : 신맛과 쓴맛 차이 작게하기 -> 가장 차이가 적은 요리 만들기
재료는 적어도 하나 이상 사용

1. 재료의 수 N
2. 재료의 신맛, 쓴맛 N번 받기
3. 조합을 구하고 신맛 쓴맛 차이 계산 (완탐)
    3-1 조합을 구하기 -> selectIngredients
        - 기저 조건 (모든 재료 검토했나 / 최소 하나라도 골랐나)
        - 기조 조건 만족 시 최소 값 업데이트
4. 최종 최소값 출력

출력 : 가장 작은 차이 출력

 */
public class Main {
    static int N;
    static int[][] ingredients; // 재료 정보 담기
    static int mindiff = Integer.MAX_VALUE; // 최대값으로 초기화
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 1. 재료의 수 N
        ingredients = new int[N][2]; // N개의 행 각 행마다 2개( 2. 재료의 신맛, 쓴맛 N번 받기)
        for(int i =0; i <N; i++) {
            ingredients[i][0] = sc.nextInt();
            ingredients[i][1] = sc.nextInt();
        }

        selectIngredients(0,1,0);

        System.out.println(mindiff);
        sc.close();
    }

    // cur : 현재 검토하고 있는 위치
    // sour
    // 각 재료마다 선택 / 미선택
    static void selectIngredients(int cur, int sour , int bitter) {
        if (cur == N) { //기저 조건 (모든 재료 검토했나 / 최소 하나라도 골랐나)
            if (bitter > 0) {
                mindiff = Math.min(mindiff, Math.abs(sour-bitter)) ; // 더 작은것으로 최소값 업데이트
            }

            return;
        }

        // 현재 재료를 선택 -> sour, bitter에 현재 값 더하고 곱하고
        selectIngredients(cur +1, sour*ingredients[cur][0], bitter + ingredients[cur][1]);


        // 현재 재료를 비선택 -> 선택안했으면 그대로 넘기기
        selectIngredients(cur+1, sour, bitter);

    }
}
