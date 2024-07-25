import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        스페이스로 띄어쓰기 된 단어들의 리스트가 주어질 때 단어들의 순서 뒤집기
        각 라인 w개의 영단어 , L개의 알파벳 가짐
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Stack<String>> map = new HashMap<>();
        int i = 1;
        while (i <= n) {
            Stack<String> stack = new Stack<>();
            String[] str = br.readLine().split(" ");

            for (int j = 0; j < str.length; j++) {
                stack.push(str[j]);

            }
            map.put(i, stack);
            i++;

        }
        int k=1;
        while(k <= n){
            Stack<String> stack = map.get(k);
            System.out.print("Case #"+k+": ");
            while(!stack.isEmpty()){
                System.out.print(stack.pop()+" ");
            }
            System.out.println();
            k++;

        }
    }
}
