import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);
        // N 개의 원소
        // Q개의 질의

        int N = sc.nextInt();
        int Q = sc.nextInt();

        int[] arr = new int[N];
        
        for(int i = 0; i< N;i++){
            //N개의 원소
            int input = sc.nextInt();
            arr[i]=input;
        }

        for(int i = 0; i<Q; i++){
            // Q개의 질의
            // 질의 형식 판단 1,2,3

            int input = sc.nextInt();
            if(input ==1){
                int x = sc.nextInt();
                System.out.println(arr[x-1]);
            } else if(input == 2){
                int idx =-1;
                int b = sc.nextInt();
                for(int j=0;j<N;j++){
                    if(arr[j]==b){
                        idx = j;
                        break;
                    }
                    if(idx== -1){
                        idx =0;
                    }

                }
                System.out.println(idx+1);
            } else if(input == 3){
                int s = sc.nextInt();
                int e = sc.nextInt();
                for(int k = s-1; k <=e-1;k++){
                    System.out.print(arr[k]+" ");
                }
            }
        }


    }
}