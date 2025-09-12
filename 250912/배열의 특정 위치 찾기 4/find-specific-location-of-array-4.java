import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int sum =0;
        int input;

        for(int i = 0; i < 10; i++){
            input = sc.nextInt();
            if(input ==0){
                break;
            }
            if(input % 2==0){
                count+=1;
                sum+=input;
            }
        }
        System.out.print(count+" "+ sum);

    }
}