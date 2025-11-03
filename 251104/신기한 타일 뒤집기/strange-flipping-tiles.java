import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int offset = 200001;
        int curPos = offset / 2;

        char[] block = new char[offset];


        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);

            if(d == 'R'){
                // 검은색
                for(int j = curPos; j< curPos+x; j++){
                    block[j] = 'B';
                }

                curPos = (curPos +x-1);
            }

            if(d == 'L'){
                // 흰색
                for(int j = curPos; j> curPos-x; j--){
                    block[j] = 'W';
                }
                curPos = (curPos -x+1);
            }
        }

        int w = 0;
        int b = 0;

        for(char bl : block){
            if(bl == 'W') w++;
            if(bl == 'B') b++;
        }

        System.out.println(w + " " + b);

    }
}