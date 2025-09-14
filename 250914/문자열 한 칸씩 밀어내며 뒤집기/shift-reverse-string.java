import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        // 첫 줄 입력 문자열 Q(요청의 개수)
        Scanner sc = new Scanner(System.in);


        String str = sc.next();
        int Q = sc.nextInt();
        int length = str.length();
        

        

        for(int i = 0 ; i < Q; i++) {
            int input = sc.nextInt();
            switch(input){
            case 1:
                str = moveFrontToBack(str, length);
                System.out.println(str);
                break;
            case 2: 
                str = moveBackToFront(str, length);
                System.out.println(str);
                break;
            case 3: 
                str = reverseString(str);
                System.out.println(str);
                break;
                }
        }

        //요청 1 : 하나씩 땡겨 맨 앞은 맨 뒤로


        // 요청 2 : 뒤로 밀고 맨 뒤는 앞으로

        // 요청 3 : 문자열 뒤집기
    }

    public static String moveFrontToBack(String str, int length) {
        char[] strArray = str.toCharArray();
        char[] newStrArray = new char[length];
        for(int i = 0; i < length; i++ ){
            if(i == length-1){
                newStrArray[i] = strArray[0];
            } else {
                newStrArray[i] = strArray[i+1];
            }

        }

        String str2 = new String(newStrArray);
        return str2;

    }

    public static String moveBackToFront(String str, int length) {
        char[] strArray = str.toCharArray();
        char[] newStrArray = new char[length];
        for(int i = 0; i < length; i++ ){
            if(i == 0){
                newStrArray[0] = strArray[length-1]; 
            } else {
                newStrArray[i] = strArray[i-1];
            }
        }
        String str1 = new String(newStrArray);
        return str1;
    }

    public static String reverseString(String str) {
        String reverseStr = new StringBuilder(str).reverse().toString();
        return reverseStr;
    }

}