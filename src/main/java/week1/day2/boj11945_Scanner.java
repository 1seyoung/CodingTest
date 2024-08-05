package week1.day2;
/*
문제 링크 : https://www.acmicpc.net/problem/11945

=============================================
로직
---------------------------------------------
입력 받는다 N, M >> 열/행 >> int[][] matrix[M][N]


 */
import java.util.Scanner;

public class boj11945_Scanner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int M = scanner.nextInt();
        int N = scanner.nextInt();
        scanner.nextLine(); // Buffer 비우기

        int[][] matrix = new int[M][N]; //행렬 선언 및 받기 (MxN) 선언 방법 외우기


        //Runtime Error NoSuchElement
        //for(int[] row : matrix){ // matrix 배열의 각 행에 대해 반복, row >> 행 의미
        //
        //    String line = scanner.nextLine(); // 한 줄 문자열 입력 받기 // 런타임에러 발생 nextLine >
        //    for (int j = 0; j <row.length; j++){//행 길이만큼 반복
        //        row[j] = line.charAt(j) - '0'; // Line 입력받으면 문자열이기 때문에 숫자 변환 과정 거쳐야함 // 문자열 아스키값 변환하고 -0
        //    }
        //}

        for (int i = 0; i < M; i++) {
            if (scanner.hasNextLine()){
                String line = scanner.nextLine();
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = line.charAt(j) - '0';
                }
            }else {
                return;
            }
        }

        // 행렬 출력
//        for (int[] row : matrix) {
//            for (int j = row.length -1; j >= 0; j--) { //행의 길이 -1 (마지막 인덱스)부터 줄여나간다 언제까지 j가 0일 때까지
//                System.out.print(row[j]);
//
//            }
//
//            System.out.println();
//
//        }
        // 행렬 좌우 반전 후 출력
        for (int i = 0; i < M; i++) {
            for (int j = N - 1; j >= 0; j--) { // 행을 역순으로 출력
                System.out.print(matrix[i][j]);
            }
            if (i < M - 1) { // 마지막 줄이 아니면 줄바꿈
                System.out.println();
            }
        }

    }
}