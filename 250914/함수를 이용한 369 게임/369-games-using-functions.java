import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        // Please write your code here.

        int count = 0;

        for(int i = A; i <=B; i++){
            if(is369(i)){
                count+=1;
            }
        }

        System.out.print(count);
    }
    public static boolean is369(int num){
        if(num %3 ==0){
            return true;
        }

        char[] arr = String.valueOf(num).toCharArray();

        for(char temp : arr){
            if(temp == '3' || temp == '6' || temp == '9') {
                return true;
            }
        }

        return false;
    }
}