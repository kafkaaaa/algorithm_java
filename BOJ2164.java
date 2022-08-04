
/*
 * BOJ 2164번(S4) - 카드2
 * Queue 활용
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2164 {

    public static void main(String[] args) {

        // 1. 제일 위에 있는 카드를 버린다.
        // 2. 제일 위에 있던 카드를 제일 아래로 옮긴다.
        // N장의 카드가 주어졌을 때, 가장 마지막에 남는 카드는?

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=N; i++) {
            q.offer(i);
        }

        while (true) {
            if (q.size() == 1) {        // 종료조건
                System.out.println(q.poll());
                break;
            }
            q.poll();           // 1. 제일 위에 있는 카드를 버린다.
            q.offer(q.poll());  // 2. 제일 위에 있던 카드를 제일 아래로 옮긴다.
        }
    }
}
