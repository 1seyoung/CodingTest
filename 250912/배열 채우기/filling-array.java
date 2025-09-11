import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int[] array = new int[10];
        int input;
        int count =0;
        for(int i = 0; i< 10; i++){
            input = sc.nextInt();
            if(input ==0){
                break;
            }
            array[i] = input;
            count+=1;
        }

        for(int i =count-1; i>=0;i--){
            System.out.print(array[i]+" ");
        }

    }
}