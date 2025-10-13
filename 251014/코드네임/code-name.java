import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String codeName = sc.next();
        int score = sc.nextInt();
        // Please write your code here.

        Agent agent = new Agent(codeName, score);

        for(int i = 0; i < 4; i ++){
            codeName = sc.next();
            score = sc.nextInt();
            agent.updateAgent(codeName, score);
        }

        agent.printAgentInfo();


    }
}

class Agent {
    String codeName;
    int score;

    public Agent(String codeName, int score) {
        this.codeName = codeName;
        this.score = score;
    }

    public void updateAgent(String codeName, int score){
        if(this.score > score) {
            this.codeName = codeName;
            this.score = score;
        }
    }

    public void printAgentInfo(){
        System.out.print(this.codeName+" "+this.score);
    }
}