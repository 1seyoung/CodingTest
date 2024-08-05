package week1.day3;

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
2.  (@, 2) , (@,N-2), (2,@), (N-2,@) => 0+2<@<N-2 -> M =3 >> 이거 채우는 부분을 재귀로 반복하기

 */
import java.util.Arrays;
import java.util.Scanner;

public class bjo10994_re {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int M = scanner.nextInt();




        int N = 4 * M - 3;  // 배열 인덱스 규칙

        char[][]matrix = new char[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(matrix[i], ' ');
        }

        int layer=2;
        drawPattern(matrix,N,2,0,0); //시작 포인트 (0,0)

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
        public static void drawPattern(char[][] matrix, int current_size,int layer, int row, int col) {
            if (current_size < 1) {
                return;
            }

            for (int i = 0; i < current_size; i++) {
                matrix[row][col + i] = '*'; // 상단
                matrix[row + current_size - 1][col + i] = '*'; // 하단
                matrix[row + i][col] = '*'; // 좌측
                matrix[row + i][col + current_size - 1] = '*'; // 우측
            }

            drawPattern(matrix,current_size -(2*layer),layer,row+layer,col+layer);

            }
}

