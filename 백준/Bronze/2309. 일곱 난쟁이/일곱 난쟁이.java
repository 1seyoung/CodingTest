
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        int i =0;
        int sum =0;
        while(i<9){
            list.add(Integer.parseInt(br.readLine().trim()));
            sum+=list.get(i);
            i++;
        }

        //난쟁이 전체 키에서 가짜 두개 빼면서 가짜 인덱스 찾기
        int fake1 = -1, fake2 = -1;

        for (int j=0; j < 8; j++){
            for(int k=j+1; k < 9; k++){
                //만약 전체값에서 - fake1 -fake2 한 값이 100이면
                if((sum - list.get(j)-list.get(k)) == 100){
                    //가짜 인덱스 나옴
                    fake1 = j;
                    fake2 = k;
                    //나오면 종료
                    break;
                }

            }
        }

        //가짜난쟁이 사라지면서 인덱스 바뀔경우 고려
        if (fake1 > fake2) {
            list.remove(fake1);
            list.remove(fake2);
        } else {
            list.remove(fake2);
            list.remove(fake1);
        }

        Collections.sort(list);

        for (int height : list) {
            System.out.println(height);
        }



    }
}
