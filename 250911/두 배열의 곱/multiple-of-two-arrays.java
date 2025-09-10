import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        int[][] array1 = new int[3][3];
        int[][] array2 = new int[3][3];

        Scanner sc = new Scanner(System.in);

        for(int i=0;i<3;i++){
            for(int j = 0; j < 3; j++) {
                int input = sc.nextInt();
                array1[i][j] = input;
            }
        }

        for(int i=0;i<3;i++){
            for(int j = 0; j < 3; j++) {
                int input = sc.nextInt();
                array2[i][j] = input;
            }
        }

        for(int i=0;i<3;i++){
            for(int j = 0; j < 3; j++) {

                System.out.print(array1[i][j] * array2[i][j] +" ");

            }

            System.out.println();
        }

    }
}