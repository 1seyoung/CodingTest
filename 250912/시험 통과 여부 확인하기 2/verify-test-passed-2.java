import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count =0;


        for(int i =0; i<N; i++){
            int sum =0;
            for(int j=0; j<4;j++){
                int input = sc.nextInt();
                sum+= input;
            }
            if(sum /4 >= 60){
                System.out.println("pass");
                count+=1;
            } else {
                System.out.println("fail");
            }
        }

        System.out.print(count);
    }
}