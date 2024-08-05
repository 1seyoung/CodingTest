package week1.day3;

import java.util.Scanner;
/*
입력 1 -> *
--------------------
입력 2 ->
*****
*   *
* * *
*   *
*****
--------------------
-> 로직1 : 안에서 부터 박스 N개/구현 방법 생각 안남 -> x
-> 로직2: line by line  -> x
입력 3
********* 3*3
*       *
* ***** *
* *   * *
* * * * *
* *   * *
* ***** *
*       *
*********
로직 -> 좌표 그림
박에부터 체크

   0 1 2 3 4 5 6 7 8 (열 x)
0  * * * * * * * * *
1  * O O O O O O O *
2  * O * * * * * O *
3  * O * O O O * O *
4  * O * O * O * O *
5  * O * O O O * O *
6  * O * * * * * O *
7  * O O O O O O O *
8  * * * * * * * * *
(행 y)
-> 매트릭스로 접근 Or 문자열
-> 입력 M
axa 배열 만들기 -> 배열 규칙  1 > 5 > 9 > 13 -->>> a = 4(N-1) + 1 >> 4N-3

1. x, y 가 0 이면 다 *
2.  (@, 2) , (@,N-2), (2,@), (N-2,@) => 0+2<@<N-2 -> M =3

 */
public class boj10994 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        if (N == 1) {
            System.out.print("*");
        }

        if (N >= 2) {
            int M = N;
            N = 4 * N - 3;  // 배열 인덱스 규칙

            char[][]matrix = new char[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = ' '; // 배열 초기화 (모든 요소를 공백으로 설정)
                }
            }

            //테두리 세팅
            for(int i = 0; i < N; i++) {
                matrix[0][i] = '*';
                matrix[N-1][i] = '*';
                matrix[i][0] = '*';
                matrix[i][N-1] = '*';
            }

            //패턴 세팅
            int layer = 2;

            while(layer < N - 2){
                for (int i = layer; i < N-layer; i++) {
                    matrix[layer][i]= '*';
                    matrix[N-layer-1][i]= '*';
                    matrix[i][layer]= '*';
                    matrix[i][N-layer-1]= '*';

                }
                layer += 2;
            }
            // 배열 출력
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(matrix[i][j]);
                }
                if (i < N - 1) { // 마지막 줄이 아니면 줄바꿈
                    System.out.println();
                }
            }

        }
    }
}