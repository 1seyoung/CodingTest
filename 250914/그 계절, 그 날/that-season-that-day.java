import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        // Please write your code here.
        // 존재하면 계절 
        // 일단 먼저 y 를 두고판단 => 윤년인가?



        if(existDay(y,m,d)){
            switch (m) {
                case 3: case 4: case 5:
                    System.out.print("Spring");
                    break;
                case 6: case 7: case 8:
                    System.out.print("Summer");
                    break;
                case 9: case 10: case 11:
                    System.out.print("Fall");
                    break;
                case 12: case 1: case 2:
                    System.out.print("Winter");
                    break;
            }
        } else {
            // 존재하지 않으면 -1
            System.out.print(-1);
        }
        

    }

    public static boolean existDay(int y, int m,int d){
        int[] dayArr;
        if(isLeapYear(y)){
            dayArr = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        } else{
            dayArr =  new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        }

        if(dayArr[m-1] >= d) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean isLeapYear(int y){
        // 윤년 조건 
        // 4의 배수면서 100의 배수가 아닌것 하지만 400의 배수면 윤년
        if(y % 4 !=0){
            return false;
        }

        if(y % 4 == 0 && y %100==0 && y %400 == 0){
            return true;
        }

        if(y %4 ==0 && y %100 != 0){
            return true;
        }

        return false;
    }
}