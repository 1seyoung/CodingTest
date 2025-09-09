import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int num = -1;
        while (true) {
            num = sc.nextInt();
            if(num ==0){
                break;
            }
            list.add(num);
        } 

        for(int item : list){
            System.out.println(item);
        }
        
    }
}