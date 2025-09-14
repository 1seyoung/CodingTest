import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        // Please write your code here.

        String reverse = new StringBuilder(input).reverse.toString();
        if(reverse.equals(input)){
            System.out.print("Yse");
        } else {
            System.out.print("No");
        }
    }
}