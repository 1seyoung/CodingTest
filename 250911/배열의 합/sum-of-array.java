import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int cnt = 0;
        for(int i = 0; i<4; i++ ){
            for(int j = 0; j <4;j++){
                int input = sc.nextInt();
                cnt += input;
            }
            System.out.println(cnt);
            cnt = 0;
        }
    }
}