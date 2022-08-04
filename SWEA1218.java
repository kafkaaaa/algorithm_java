
/*
 * SWEA 1218번(D4) - 괄호 짝짓기
 * stack 활용
 */

import java.util.Scanner;
import java.util.Stack;

public class SWEA1218 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        for (int tc=1; tc<=10; tc++) {
            Stack<Character> stack = new Stack<>();
            int len = scan.nextInt();
            String s = scan.next();
            for (int i=0; i<len; i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[' || c == '{' || c == '<') {
                    stack.push(c);
                }
                else if (c == ')') {
                    if (!(stack.peek() == '(')) break;
                    stack.pop();

                }
                else if (c == ']') {
                    if (!(stack.peek() == '[')) break;
                    stack.pop();
                }
                else if (c == '}') {
                    if (!(stack.peek() == '{')) break;
                    stack.pop();
                }
                else if (c == '>') {
                    if (!(stack.peek() == '<')) break;
                    stack.pop();
                }
            }

            int answer = 1;     // 1: 유효함,  0: 유효하지 않음
            if (!stack.isEmpty()) answer = 0;
            System.out.println("#" + tc + " " + answer);
        }
    }
}
