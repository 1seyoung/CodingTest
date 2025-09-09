import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        boolean isMatched = false;
        int temp = -1;
        while(!isMatched){
            temp = sc.nextInt();
            if(temp > 25){
                System.out.println("Lower");
            } else if(temp < 25){
                System.out.println("Higher");
            } else {
                System.out.println("Good");
                isMatched = true;
            }


        }
    }
}