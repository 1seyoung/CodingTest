
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //1. 테스트 케이스 수 T 입력받기
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        //2. 테스트 케이스 만큼 전체 과정 반복 while(n-- >0)
        while(T-->0){
            //3. 지원자 수 받기 int N
            int N = sc.nextInt();

            //4. N번 입력 받기 반복-> 서류 점수, 면접 순위 (line) Map<int, int>
            //5. 서류 기준으로 오름차순 정렬 (서류 성적이 낮은 지원자부터 비교해서 선별하면 면접 점수만 비교하면 될 것 같음)
            //TreeMap<Integer, Integer> application = new TreeMap<>(); // TreeMap 을 사용하면 자동으로 키 순서로 정렬해준다는디요
            List<int[]> applicants = new ArrayList<>(); //5 수정 : 시간 복잡도 문제 해결 위해서
            for (int i = 0; i < N; i++) {
                applicants.add(new int[]{sc.nextInt(), sc.nextInt()});
            }

            //5-1(수정버전) 정렬 추가
            applicants.sort((a, b) -> Integer.compare(a[0], b[0]));


            //6. 합격자 선발(면접 순위의 숫자가 현재 Max 값보다 작으면 높은 순위이므로 적어도 하나의 점수가 높은 것을 의미함)
            //6-1 Max 값 정의, 인원수 정의
            int maxValue = Integer.MAX_VALUE;
            int entryCount =0;

            //6-1 순위 비교
            //for (Map.Entry<Integer, Integer> entry : application.entrySet()) {
            //    if (entry.getValue() < maxValue) {
            //        entryCount ++;
            //        maxValue = entry.getValue();
            //    }
            //}
            //(수정) 시간 복잡도 문제 해결
            for (int[] applicant : applicants) {
                if (applicant[1] < maxValue) {
                    entryCount++;
                    maxValue = applicant[1];
                }
            }
            System.out.println(entryCount);
        }


    }
}
