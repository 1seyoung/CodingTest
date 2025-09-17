import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here

        char[] arr = String.valueOf(n).toCharArray();

        int length = arr.length;
        function(length, n , 0);

    }

    public static void function(int length, int n, int sum){
        if(length==0){
            System.out.print(sum);
            return ;
        }

        int digit = (n % 10);

        sum += (digit * digit);

        function(length-1, n /10 , sum);

    }
}