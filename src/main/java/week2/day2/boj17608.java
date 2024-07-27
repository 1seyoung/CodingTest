package week2.day2;

import java.util.Scanner;
import java.util.Stack;

public class boj17608 {
    /*
    구현, 자료구조, 스택
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();
        int count = 0;
        int max = 0;
        int current =0;

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            stack.push(scanner.nextInt());
        }

        for(int i = 0; i < n; i++){

            current = stack.pop();

            if(current > max) {
                max = current;
                count ++;
            }
        }

        System.out.println(count);
    }
}
