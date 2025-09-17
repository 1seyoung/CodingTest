import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        // 11(n) n-2 n-4  ... 1 3 5 7
        // A1 = 1 , A2= 3, AN =  2N-1(일반항)
        // 홀수의 합 -> 2(1 +~+ N) -N = n(n+1)-n = n^2

        // 짝수의 합 -> n(n+1)


        if(n % 2 == 0){
            // 짝수 
            int x = n/2;
            System.out.print(x * (x+1));
        } else {
            int x = n/2 +1;
            System.out.print(x *x);
        }

    }
}