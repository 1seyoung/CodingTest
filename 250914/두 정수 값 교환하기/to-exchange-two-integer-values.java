import java.util.Scanner;

class IntWrapper {
    int value;

    public IntWrapper(int value){
        this.value = value;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // Please write your code here.

        IntWrapper nCopy = new IntWrapper(n);
        IntWrapper mCopy = new IntWrapper(m);

        swap(nCopy,mCopy);

        System.out.print(nCopy.value + " "+ mCopy.value);
    }

    public static void swap(IntWrapper a, IntWrapper b) {
        int temp = a.value;
        a.value = b.value;
        b.value = temp;

        
    }
}