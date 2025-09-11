import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int input;
        int sum = 0;
        for(int i = 0; i < 10 ; i++){
            input = sc.nextInt();
            sum += input;
        }

        System.out.print(sum);


    }
}