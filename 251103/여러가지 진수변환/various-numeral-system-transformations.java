import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        // Please write your code here.

        // 10진수 N , 바꿀진수 B, 
        
        StringBuilder sb = new StringBuilder();

        while(true){
            if(n < b){
                sb.append(n % b);
                break;
            }

            sb.append(n % b);
            n = n/b;
        }

        System.out.print(sb.reverse());
    }
}