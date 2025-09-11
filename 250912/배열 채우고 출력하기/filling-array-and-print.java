import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        String[] arr = line.split(" ");

        for(int i = 9; i >=0 ; i--){
            System.out.print(arr[i]);
        }
    }
}