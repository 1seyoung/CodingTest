import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);
        int sum=0;
        for(int i = 0; i<10; i++){
            int input = sc.nextInt();
            if(i ==2){
                sum+=input;
            }else if(i==4){
                sum+=input;
            } else if(i==9){
                sum+=input;
            }
        }

        System.out.print(sum);

    }
}