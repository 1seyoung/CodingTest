import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        int m = n;

        printNum(n,m);
        System.out.println();
        printNumReverse(n);
    }

    public static void printNum(int n,int m){
        if(m==0){
            return;
        }
        System.out.print(n-m+1+" ");
        printNum(n,m-1);

    }

    public static void printNumReverse(int n){
        if(n==0){
            return;
        }
        System.out.print(n+" ");
        printNumReverse(n-1);
    }   
}