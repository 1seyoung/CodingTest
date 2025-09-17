import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        // 피보나치 수열 : 이전 두 항의 합이 그 다음 항이 되는 수열을 의미
        // 점화식을 찾아라 -> A1 = 1, A2 = 1, An = A(n-2) + A(n-1)
        System.out.print(Fuction(n));
    }

    public static int Fuction(int n){
        if(n ==1){
            return 1;
        } 
        if(n==2){
            return 1;
        }

        return Fuction(n-2) + Fuction(n-1);
    }
}