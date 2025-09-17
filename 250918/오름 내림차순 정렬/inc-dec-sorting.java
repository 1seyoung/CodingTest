import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.

        int[] arr2 = Arrays.sort(arr)

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
        
        System.out.println();

        for (int i = n-1; i >= 0 ; i--) {
            System.out.print(arr[i]+" ");
        }


    }
}