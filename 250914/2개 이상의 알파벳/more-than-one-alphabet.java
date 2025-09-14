import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        // Please write your code here.

        char[] arr = A.toCharArray();

        Set<Character> set = new HashSet<>();
        for(char a : arr){
            set.add(a);
        }


        if(set.size() >= 2){
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }
}