import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for(int i =1 ; i <=N; i++){
            for(int j=1;j<=N;j++){
                String str1 = String.valueOf(i);
                String str2 = String.valueOf(j);
                String str3 = String.valueOf(i*j);
                if(j<N){
                    System.out.print(i+" * "+j+" = "+str3+", ");
                } else  {
                    System.out.println(i+" * "+j+" = "+str3);
                }

            }
        }
    }
}