import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int temp = a;
        boolean flag = true;

        while(flag){
            System.out.print(temp+" ");
            if(temp %2 == 1){
                temp *= 2;
            } else {
                temp +=3;
            }
            if(temp > b){
                flag = false;
            }

        }
    }
}