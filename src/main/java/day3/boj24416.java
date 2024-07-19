package day3;

import java.util.Scanner;
/*
문제 목표 : 재귀함수와 DP 속도 비교
피보나치 점화식 : f(n) = f(n-1)+ f(n-2) >>> (n>=2) ,f(2) = f(1) = 1
 */
public class boj24416 {
    public static void main(String[] arg){

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        System.out.print(fibo_recursion(N)+" " +fibo_dp(N));

    }

     static int fibo_recursion(int n){

        if (n == 1 || n == 2){
            return 1;
        }
        else {

            return fibo_recursion(n-1) + fibo_recursion(n-2); //코드 1

        }
    }
    static int fibo_dp(int n) {
        int task=0;

        int[] f = new int[n+1]; //배열 크기 n+1로 설정하는 이유 : 1~n까지 사용하기 위해
        f[1] = f[2] = 1;

        for (int i = 3; i <= n; i++){
            f[i] = f[i-1] +f[i-2]; //코드2
            task += 1;
        }

        return task;
    }
}
