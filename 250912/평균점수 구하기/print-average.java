import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        double sum = 0.0;
        double input;

        for(int i = 0; i < 8; i++){
            input = sc.nextDouble();
            sum += input;
        }

        double aver = Math.round(sum / 8.0 *10)/10.0;
        System.out.print(aver);
    }
}