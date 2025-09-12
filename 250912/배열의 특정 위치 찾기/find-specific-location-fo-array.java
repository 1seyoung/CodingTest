import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        // 짝수 번째 값 합
        // 3의 배수 입력 값 평균

        Scanner sc = new Scanner(System.in);

        int sum1=0;
        double sum3=0.0;
        double aver3=0.0;
        int count =0;

        for(int i = 0;i<10;i++){
            int input = sc.nextInt();
            if(i%2==1){
                sum1+=input;
            }

            if((i+1)%3==0){
                sum3+=(double)input;
                count+=1;
            }
        }

        aver3 = Math.round(sum3 / (double)count*10)/10.0;

        System.out.print(sum1 +" "+aver3);
    }
}