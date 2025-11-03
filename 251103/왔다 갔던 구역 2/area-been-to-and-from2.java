import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] blocks = new int[2001];
        int start = 1000;
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);
            // Please write your code here.
            
            if(dir == 'R'){
                // +
                for(int j = start; j < start +x; j++){
                    blocks[j] +=1;
                }

                start = start +x;

            } 

            if(dir == 'L'){
                for(int j = start - x; j <start;j++){
                    blocks[j] +=1;
                }

                start = start -x;
            }

        }

        int answer = 0;
        for(int b : blocks){
            if(b >=2) answer++;
        }

        System.out.print(answer);
    }
}