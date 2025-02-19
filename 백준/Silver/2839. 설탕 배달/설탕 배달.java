import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main  {

  public static void main(String[] args) throws IOException {

    // 숫자 입력받기

    // 5로 나누어서 몫 구하기 (몫 저장)

    // 마너지 3으로 나누기 나누어떨어지는지 확인하기 나누어 떨어지면 또 몫 킵

    // 몫합 출력

    // + 5키로를 최대한 사용하는게 최적은 x 나머지가 3kg 으로 나누어지지 않으면 하나씩 줄여본다 5키로 봉지를


    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int count = -1; // 기본값: 만들 수 없는 경우 -1
    int maxFiveKg = N / 5;


    for(int i = maxFiveKg; i >=0; i--) {
      int remain = N - (i*5) ;
      if (remain % 3 ==0) {
        count = i + (remain / 3);
        break;
      }
    }
    System.out.println(count);
    
      }

    }
