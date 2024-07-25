
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        String initialText = br.readLine().trim();

        for (char ch : initialText.toCharArray()) {
            leftStack.push(ch);
        }

        int M = Integer.parseInt(br.readLine().trim());

        String command;

        for(int i = 0; i < M; i++) {
            command = br.readLine();
            editor(command,leftStack,rightStack);
        }
        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }

        System.out.println(sb.toString());

    }

    static void editor(String command,Stack<Character> leftStack,Stack<Character> rightStack){
        /*
        L	 |   커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
        -------------------------------------------------------------------------------------------
        D	 |   커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
        -------------------------------------------------------------------------------------------
        B	 |   커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
         	 |   삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
        -------------------------------------------------------------------------------------------
        P $  |   $라는 문자를 커서 왼쪽에 추가함
        -------------------------------------------------------------------------------------------
         */

        switch (command.charAt(0)) {
            case 'L':
                if (!leftStack.isEmpty()) {
                    rightStack.push(leftStack.pop());
                }
                break;

            case 'D':
                if (!rightStack.isEmpty()) {
                    leftStack.push(rightStack.pop());
                }
                break;

            case 'B':
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                }
                break;

            case 'P':
                leftStack.push(command.charAt(2));
                break;
        }

        }
    }

