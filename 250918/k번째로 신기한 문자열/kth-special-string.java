import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String t = sc.next();
        String[] words = new String[n];
        int m = 0;
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            String part = s.substring(0,2);
            if(part.equals(t)){
                words[m] = s;
                m+=1;
            }
        }
        // Please write your code here.

        String[] filtered = Arrays.copyOf(words,m);

        Arrays.sort(filtered);

        System.out.print(filtered[k-1]);
    }
}