import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.next();
        // Please write your code here.

        int result =0;
        int base = 1;

        for(int i = binary.length()-1; i >= 0 ; i--){
            char c = binary.charAt(i);
            if(c == '1'){
                result += base;
            }
            base *= 2;
        }

        System.out.print(result);
    }
}