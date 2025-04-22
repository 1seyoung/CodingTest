/*
세계는 균형이 잘 잡혀있어야 한다. 양과 음, 빛과 어둠 그리고 왼쪽 괄호와 오른쪽 괄호처럼 말이다.

정민이의 임무는 어떤 문자열이 주어졌을 때, 괄호들의 균형이 잘 맞춰져 있는지 판단하는 프로그램을 짜는 것이다.

문자열에 포함되는 괄호는 소괄호("()") 와 대괄호("[]")로 2종류이고, 문자열이 균형을 이루는 조건은 아래와 같다.

모든 왼쪽 소괄호("(")는 오른쪽 소괄호(")")와만 짝을 이뤄야 한다.
모든 왼쪽 대괄호("[")는 오른쪽 대괄호("]")와만 짝을 이뤄야 한다.
모든 오른쪽 괄호들은 자신과 짝을 이룰 수 있는 왼쪽 괄호가 존재한다.
모든 괄호들의 짝은 1:1 매칭만 가능하다. 즉, 괄호 하나가 둘 이상의 괄호와 짝지어지지 않는다.
짝을 이루는 두 괄호가 있을 때, 그 사이에 있는 문자열도 균형이 잡혀야 한다.
정민이를 도와 문자열이 주어졌을 때 균형잡힌 문자열인지 아닌지를 판단해보자.

각 줄마다 해당 문자열이 균형을 이루고 있으면 "yes"를, 아니면 "no"를 출력한다.
입력 예시
So when I die (the [first] I will see in (heaven) is a score list).
[ first in ] ( first out ).
Half Moon tonight (At least it is better than no Moon at all].
A rope may form )( a trail in a maze.
Help( I[m being held prisoner in a fortune cookie factory)].
([ (([( [ ] ) ( ) (( ))] )) ]).
 .
.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    // s 문자열의 각 문자 한 개씩 고려
    // '(' : 뒤에서 닫는 ')' 만나면 함께 유효한 문자이므로 일단 자료구조(Stack) 에 저장
    // ')' : 바로 이전 문자( Stack 에서 pop() )가 '(' 이어야 유효 => 유효한 2개 문자는 제거
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader와 BufferedWriter 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        // 입력의 종료 조건은 한 줄에 점(.)만 들어오는 경우입니다.
        while (!(line = br.readLine()).equals(".")) {
            // 각 줄마다 새로운 스택을 생성하여 검사
            Deque<Character> stack = new ArrayDeque<>();
            boolean balanced = true;

            // 문자열의 각 문자를 확인
            for (char c : line.toCharArray()) {
                // 여는 괄호이면 스택에 저장
                if (c == '(' || c == '[') {
                    stack.push(c);
                }
                // 닫는 소괄호인 경우
                else if (c == ')') {
                    // 스택이 비어있거나 top에 있는 문자가 '('가 아니라면 불균형 처리
                    if (stack.isEmpty() || stack.peek() != '(') {
                        balanced = false;
                        break;
                    }
                    // 올바른 경우, pop하여 제거
                    stack.pop();
                }
                // 닫는 대괄호인 경우
                else if (c == ']') {
                    // 스택이 비어있거나 top에 있는 문자가 '['가 아니라면 불균형 처리
                    if (stack.isEmpty() || stack.peek() != '[') {
                        balanced = false;
                        break;
                    }
                    // 올바른 경우, pop하여 제거
                    stack.pop();
                }
                // 다른 문자는 무시
            }

            // 모든 문자 처리 후 스택에 남은 괄호가 있다면 균형이 맞지 않음
            if (!stack.isEmpty()) {
                balanced = false;
            }
            bw.write(balanced ? "yes" : "no");
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}