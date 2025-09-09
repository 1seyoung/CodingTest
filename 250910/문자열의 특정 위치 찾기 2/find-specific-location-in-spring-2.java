import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);
        char str = sc.next().charAt(0);

        String[] strList = {"apple", "banana", "grape", "blueberry", "orange"};

        
        int count = 0;

        for(int i = 0; i < 5; i++ ) {
            String temp = strList[i];
            boolean matched = false;

            if(temp.length() >= 3) {
                if(temp.charAt(2) == str) {
                matched = true;

                }
            }

            if(temp.length() >= 4) {
                if(temp.charAt(3) == str) {
                matched = true;
                }
            }

            if(matched){
                    count+=1;
                    System.out.println(temp);
            }
        }

        System.out.print(count);
    }
}