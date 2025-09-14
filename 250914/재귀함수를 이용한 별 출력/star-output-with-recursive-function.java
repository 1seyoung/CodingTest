import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        int m = n;
        printStar(n,m);
    }

    public static void printStar(int n, int m){
        if(m==0){
            return;
        }

        for(int i = 0; i <n-m+1;i++){
            System.out.print("*");
        }
        System.out.println();
        printStar(n,m-1);
    }


}