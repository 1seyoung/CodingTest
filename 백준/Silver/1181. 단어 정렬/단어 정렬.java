
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //1, N 입력받기
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String s;
        int sLength;
        Map<String, Integer> map = new HashMap<>();

        //2. N번 반복해서 문자열 입력 받기
        while (N-- > 0) {
            //3. 문자열을 입력받기 > 중복 있으면 저장 x >  문자열 , 문자열 길이 쌍으로 저장
            s = sc.next();
            sLength = s.length();

            //중복일 시 저장 x
            if(!map.containsKey(s)) {
                map.put(s, sLength);
            }

        }

        // 4. 문자열 정렬 -> 1차 기준: 갈이 , 2차 기준 : 사전 순
        //Compator과 Sort 사용  ->>> 두개의 조합으로 리스트 요소 원하는 기준으로 쉽게 정렬 가능
        //4-1  Map 키값 저장하는 리스트 만들기
        List<String> keyList = new ArrayList<>(map.keySet());
        keyList.sort(new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    //4-2 두 문자열의 길이가 다른 경우
                    return Integer.compare(s1.length(), s2.length()); //두 길이를 비교하여 길이가 작은 문자열이 앞에 오도록 함
                }else{ //4-3 문자열 길이가 같으면 사전순
                    return s1.compareTo(s2);
                }
            }
        });
        for (String str : keyList) {
            System.out.println(str);
        }


    }
}
