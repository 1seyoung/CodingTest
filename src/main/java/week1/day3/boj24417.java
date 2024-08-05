package week1.day3;

import java.util.Scanner;
/*
피보나치 점화식 : f(n) = f(n-1)+ f(n-2) >>> (n>=2) ,f(2) = f(1) = 1
1000000007 = 1e9 + 7 라는 숫자는 큰 수의 계산을 처리하기 위해 사용되는 소수
 */
public class boj24417 {
    static  long code1count, code2count ;//실행횟수 저장 변수

    static  int Mod = 1000000007;
    public static void main(String[] arg){

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        code1count =0;
        code2count=0;

        fibo_recursion(N);
        fibo_dp(N);

        System.out.println(code1count +" "+code2count);

    }

    static long fibo_recursion(int n){

        if (n == 1 || n == 2){

            code1count +=1;
            return 1;
        }
        else {
            return fibo_recursion(n-1) + fibo_recursion(n-2) %Mod; //코드 1

        }
    }
    static int fibo_dp(int n) {

        int[] f = new int[n+1]; //배열 크기 n+1로 설정하는 이유 : 1~n까지 사용하기 위해
        f[1] = f[2] = 1;

        for (int i = 3; i <= n; i++){
            f[i] = f[i-1] +f[i-2];//코드2
            code2count +=1;
        }

        return f[n];
    }
}
