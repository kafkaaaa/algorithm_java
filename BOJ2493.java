
/*
 * BOJ 2493번(G5) - 탑
 * stack 활용
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493 {

    public static void main(String[] args) throws IOException {

        // 1 <= 탑의 개수 <= 500,000
        // 1 <= 탑의 높이 <= 100,000,000
        // 다음 탑의 높이를 입력 받을 때 이전까지 stack에 있던 높이들 중 자신보다 큰 값이 있어야 레이저 수신 가능.
        // (탑의 인덱스번호, 탑의 높이)를 저장하는 스택 자료구조 사용 -> Stack<int[]>

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Stack<int[]> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int height = Integer.parseInt(st.nextToken());  // 다음 탑의 높이
            while(!stack.isEmpty()) {
                if (stack.peek()[1] < height) {    // 수신 불가능
                    stack.pop();
                }
                else {                          // 수신 가능
                    System.out.print(stack.peek()[0] + " ");
                    break;
                }
            }
            if (stack.isEmpty()) System.out.print("0 ");
            stack.push(new int[] {i+1, height});
        }

    }
}
