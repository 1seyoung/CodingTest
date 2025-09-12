import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = {0,0,0,0,0,0,0,0,0,0}

        for(int i =0; i< N; i++){
            int input = sc.nextInt();
            array[input-1] +=1;            
        }


        for(int temp : array){
            System.out.println(temp);
        }
    }
}