public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int input;
        int sum =0;
        int count =0;
        for(int i = 0; i< 10;i++){
            input = sc.nextInt();
            if(input ==0){
                break;
            }
            sum+=input;
            count+=1;
        }

        double aver = Math.round(sum/(double)count*10) /10.0;
        System.out.print(sum+" "+aver);
    }
}