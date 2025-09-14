import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        int m = n;
        sumN(n,m,0);
    }

    public static void sumN(int n,int m, int sum){
        if(m==0){
            System.out.print(sum);
            return;
        }
        sum += (n-m+1);
        m-=1;
        sumN(n,m,sum);
    }
}