import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Number[] numbers = new Number[n];
        for(int i = 0; i < n; i++){
            int num = sc.nextInt();
            numbers[i] = new Number(i+1,num);
        }
        // Please write your code here.

        Arrays.sort(numbers);

        int[] newIndex = new int[n+1];
        for(int i = 0; i<n;i++){
            newIndex[numbers[i].order] = i+1;
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(newIndex[i]+" ");
        }

    }
}

class Number implements Comparable<Number>{
    int order;
    int number;

    public Number(int order, int number){
        this.order = order;
        this.number = number;
    }

    @Override
    public int compareTo(Number e){
        if (this.number != e.number) return this.number - e.number;
        return this.order - e.order;
    }
}