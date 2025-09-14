import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        String line = sc.nextLine();
        String[] arr = line.split(" ");

        if(arr[0].length() > arr[1].length()){
            System.out.print(arr[0]+" "+arr[0].length());
        } else if (arr[0].length() < arr[1].length()) {
            System.out.print(arr[1]+" "+arr[1].length());
        } else{
            System.out.print("same");
        }
        
    }
}