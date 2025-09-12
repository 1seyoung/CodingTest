import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        // N 개
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int max1 = Integer.MIN_VALUE; // 제일 큰 값
        int max2 = Integer.MIN_VALUE; // 두 번째로 큰 값
        for(int i = 0 ; i < N; i++) {
          int input = sc.nextInt();

          if(input >= max1){
            // 최고 큰 값이었으면
            max2 = max1;
            max1 = input;
          }  else if (input >= max2) {
            max2 = input;
          }
        }

        System.out.print(max1+" "+max2);
    }
}