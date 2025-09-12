import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        // N1 개의 원소로 이루어져있는 수열 A 
        // N2 개의 원소로 이루어져있는 수열 B
        // B가 A의 연속부분수열인지 판단

        // 연속부분수열 : B가 A의 원소를 연속하게 뽑았을 때 나올 수 있는 수열인지

        // 입력 첫줄

        Scanner sc = new Scanner(System.in);
        int N1 = sc.nextInt();
        int N2 = sc.nextInt();

        if(N1 <N2){
            System.out.print("No");
            return;
        }

        int[] arrA = new int[N1];
        int[] arrB = new int[N2];

        //A
        for(int i = 0; i< N1; i++){
            int input = sc.nextInt();
            arrA[i] = input;
        }

        //B
        for(int i = 0; i< N2; i++){
            int input = sc.nextInt();
            arrB[i] = input;
        }

        // N2-(N1 -1) -> N2-N1+1

        int X = N2-N1+1;

        for(int i = 0; i< X; i++ ){
            int[] slice = Arrays.copyOfRange(arrA, i, i+N2-1);
            if(slice == arrB){
                System.out.print("Yes");
                break;
            }
        }

        System.out.print("No");


    }
}