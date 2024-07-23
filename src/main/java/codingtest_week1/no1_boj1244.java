package codingtest_week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class no1_boj1244 {
    public static void main(String[] args) throws IOException {
        /*
        중요 로직 1. 남학생은 스위치 번호가 자기가 받은 수의 배수이면, 그 스위치의 상태를 바꾼다.
        중요 로직 2. 여학생은 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서, 그 구간에 속한 스위치의 상태를 모두 바꾼다. 이때 구간에 속한 스위치 개수는 항상 홀수
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //1. 스위치 수 입력 받기( 100이하 양의 정수)
        int N  = Integer.parseInt(br.readLine());
        //2. 스위치 초기 상태 리스트 받기 -> 스위치의 상태를 1번 스위치에서 시작하여 마지막 스위치까지 한 줄에 20개씩 출력한다. 예를 들어 21번 스위치가 있다면 이 스위치의 상태는 둘째 줄 맨 앞에 출력한다.

        ArrayList<Integer> switch_original = new ArrayList<>();
        String[] switchStates = br.readLine().split(" ");
        for (String state : switchStates) {
            switch_original.add(Integer.parseInt(state));
        }



        //2-1. 리스트 20개씩 분할하여 이차원 리스트로 저장해두기
        int switchStandardLine = 20;
        List<List<Integer>> switches = new ArrayList<>(); // 리스트 안에 리스트


        for (int i = 0; i < N; i += switchStandardLine) {
            int end = Math.min(i + switchStandardLine, N); // 지금 i+20-> 넘어가야할 인덱스가 있고 맨 마지막이있을때 더 작은게 end
            switches.add(new ArrayList<>(switch_original.subList(i,end))); //시작 0부터 줄의 마지막 인덱스까지
        }


        //3. 학생 수 입력 받기
        int studentNum  = Integer.parseInt(br.readLine());


        //4. 학생 성별, 받은 숫자 페어2 입력 받기 (1 : 남자, 2: 여자) ... -> 학생 수 체크해야함 + 스위치 온오프
        int gender = 0;
        int standardNum = 0;
        for (int i = 0; i < studentNum; i++) {
            String[] str = br.readLine().split(" ");
            gender = Integer.parseInt(str[0]);
            standardNum = Integer.parseInt(str[1]);


            //9. 페어 순서에 따라 함수 호출 switch문 (pair1[0] ==1) -> 남자 , else -> 여자
            switch (gender){
                case 1: // 남학생
                    switches = boySwitchOn(switches,standardNum,N);
                    break;
                case 2:
                    switches = girlSwitchOn(switches,standardNum,N);
                    break;
            }

        }
        for (List<Integer> switchLineList : switches) {
            for (int i = 0; i < switchLineList.size(); i++) {
                sb.append(switchLineList.get(i)).append(" ");
                if ((i + 1) % 20 == 0) {
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb.toString());

    }
        //7. 남학생일 때 스위치 함수
        static List<List<Integer>> boySwitchOn(List<List<Integer>> switches, int standardNum, int switchCount){
            //7-1. 스위치 상태와, 숫자, 스위치 수 인자 넘겨받기
            int currentIndex = 0;
            //7-2. 반복한다 얼마만큼? 숫자 배수가 스위치 수 보다 작거나 같을때까지
            for (int i = 1; i*standardNum <= switchCount; i++) {
                currentIndex = i * standardNum - 1;

                int row = currentIndex/20;
                int col = currentIndex%20;
                //7-3 if 스위치[현재위치] 가 0이면 1로, 1이면 0으로
                switches.get(row).set(col,switches.get(row).get(col) == 0 ? 1 : 0);


            }
            //7-4 return 스위치
            return switches;
        }


        //8 여학생일 때 스위치 함수
        static List<List<Integer>> girlSwitchOn(List <List<Integer>> switches, int standardNum, int switchCount){
            //8-1  스위치 상태와, 숫자, 스위치 수 인자 넘겨받기

            //8-2 구현 : 여학생은 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서, 그 구간에 속한 스위치의 상태를 모두 바꾼다. 이때 구간에 속한 스위치 개수는 항상 홀수
                //스위치를 중심으로 좌우 대칭 -> center
            int center = standardNum - 1;

            int row = center/20;
            int col = center%20;

                //좌우로
            int left = center;
            int right = center;
                // left >= 0 : 왼쪽 인덱스가 0 이상이어야함
                // right < switchCount : 오른쪽 인덱스가 전체 스위치 수보다 크면 안됨
                // switches.get(left / 20).get(left % 20).equals(switches.get(right / 20).get(right % 20))  : 좌우 대칭의미
                //  switches.get(left / 20).get(left % 20) 왼쪽인덱스의 R,c 구해서 나온 값과 오른쪾(switches.get(right / 20).get(right % 20))  이 같아야함
                // 위 3개가 동시에 만족해야함 && &&
            while (left >= 0 && right < switchCount && switches.get(left / 20).get(left % 20).equals(switches.get(right / 20).get(right % 20))) {
                //만족하면 좌우 인덱스 이동
                left--;
                right++;
            }
            //좌우 찾았으면 종료하고 상태 변경 진행
            for (int i = left+1; i < right; i++) {
                int r = i / 20;
                int c = i % 20;
                switches.get(r).set(c, switches.get(r).get(c) == 0 ? 1 : 0);
            }

            return switches;
        }


}
