import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in); 
        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N ; i++) {
            int input = sc.nextInt();
            arr[i] = input;
        }


        // 최댓값의 idx +1 구하기 (똑같은 값이 있다면 왼쪽 위치)

        ArrayList<Integer> maxValueIdx = new ArrayList<>();
        
        boolean flag = false;
        int right = N - 1;
        while(!flag){
            int max = Integer.MIN_VALUE;;
            int maxIdx = -1;
            for(int i = 0; i <right; i++){
                if(max < arr[i]){
                    max = arr[i];
                    maxIdx = i; //2
                }
            }

            maxValueIdx.add(maxIdx+1);
            right = maxIdx - 1;

            if(maxIdx ==0){
                flag = true;
            }
        }

        for(int temp : maxValueIdx){
            System.out.print(temp +" ");
        }

    }
}