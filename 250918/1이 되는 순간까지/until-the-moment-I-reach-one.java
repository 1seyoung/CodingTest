import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        targetAction(n, 0);
    }

    public static void targetAction(int num, int count){
        if(num ==1){
            System.out.print(count);
            return;
        }

        if(num % 2 ==0){
            //짝수면
            targetAction(num / 2, count+1);
        } else {
            targetAction(num / 3, count+1);
        }
    }
}