import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        for(int i = 0; i< input; i++){
            for(int j = 0; j<input-i;j++){
                System.out.print("* ");
            
            }
            for(int k = i; k >0; k-- ){
                System.out.print("  ");
            }
            System.out.println();
        }
    }
}