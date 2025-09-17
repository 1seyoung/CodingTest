import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        // Please write your code here.

        int n = a * b * c;

        char[] arr = String.valueOf(n).toCharArray();

        int length = arr.length;

        fuction(n, length,0);
    }

    public static void fuction(int num, int length, int sum){
        if(length==0){
            System.out.print(sum);
            return;
        }

        sum += (num % 10 );
        fuction(num /10, length-1, sum);
    }

}