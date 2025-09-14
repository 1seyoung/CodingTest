import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        long gcd = Math.gcd(n,m);
        long lcm = n / gcd * m;

        System.out.print(lcm);
    }
}