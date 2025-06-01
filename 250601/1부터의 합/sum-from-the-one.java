import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int i = 1;
        int sum = 0;
        while(true) {
            sum += i;

            if (sum>=N){
                System.out.print(i);
                break;
            }
            i++;
        }
    }
}