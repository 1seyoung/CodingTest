import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int level = sc.nextInt();
        // Please write your code here.

        Info info1 = new Info();
        Info info2 = new Info(id, level);

        info1.printInfo();
        info2.printInfo();
    }
}

class Info {
    String id;
    int level;

    public Info(){
        this.id = "codetree";
        this.level = 10;
    }
    public Info(String id, int level) {
        this.id = id;
        this.level = level;
    }

    public void printInfo(){
        System.out.print("user "+ this.id);
        System.out.println(" lv "+this.level);
    }
}