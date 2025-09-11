 import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        // 과목 수 N 
        // 평균학점
        // 4.0 이상 Perfect , 3.0 이상 Good, 미만 Poor

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        double input ;
        double sum = 0.0;
        for(int i = 0; i < N; i++){
            input = sc.nextDouble();
            sum += input;
        }

        double aver = Math.round(sum / (double)N *10) /10.0;

        System.out.println(aver);
        if(aver >=4.0){
            System.out.print("Perfect");
        } else if (aver >= 3.0){
            System.out.print("Good");
        } else {
            System.out.print("Poor");
        }
    }
}