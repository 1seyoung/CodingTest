class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int r2 = arr2.length;
        int c2 = arr2[0].length;
        
        //결과 저장할 2차원 배열 초기화
        //첫 번째 행렬 A의 열 개수와 두 번째 행렬 B의 행 개수가 같아야 곱셈 가능.즉, A(m x n) * B(n x p) → 결과 행렬 C(m x p)
        int [][] answer = new int[r1][c2];
        
        for (int i = 0; i < r1; i++) {      // A의 행 개수만큼 반복
            for (int j = 0; j < c2; j++) {  // B의 열 개수만큼 반복
                for (int k = 0; k < c1; k++) {  // A의 열 개수(=B의 행 개수)만큼 반복
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        
        return answer;
    }
}