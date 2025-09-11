import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        // 500 이하 숫자 총 10번 주어짐 
        // 250 이상 정수 주어지면 마지막 빼고 합계와 평균 계산 
        // 안나오면 그냥 10개 합계 평균

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<>();
        int input;
        int sum = 0;
        int count = 0;
        for(int i = 0; i < 10; i++){
            input = sc.nextInt();
            if(input >=250){
                break;
            }
            sum+=input;
            count +=1;

        }

        double aver = Math.round((sum/(double)count)*10)/10.0;
        

        System.out.print(sum +" "+ aver);
    }
}