import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int gdcValue = gdc(n,m);
        int lcmValue = n * m/gdcValue;

        System.out.print(lcmValue);

    }

    public static int gdc(int a, int b) {
        while(b !=0){
            int temp = a % b;
            a=b;
            b = temp;
        }
            return a;
    }


}