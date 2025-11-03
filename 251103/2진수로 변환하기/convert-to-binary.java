import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        StringBuilder sb = new StringBuilder();

        while(true){
            if(n < 2){
                sb.append(n % 2);
                break;
            }
            sb.append(n % 2);
            n = n/2;
        }

        System.out.print(sb.reverse());
    }
}