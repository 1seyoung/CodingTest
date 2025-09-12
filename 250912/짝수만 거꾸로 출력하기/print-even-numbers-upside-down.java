import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        ArrayList<Integer> array = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        
        for(int i = 0; i<N;i++){
            int input = sc.nextInt();
            if(input % 2==0){
                array.add(input);
            }
        }

        int length = array.size();

        for(int i = length-1; i>=0;i--){
            System.out.print(array.get(i)+" ");
        }
    }
}