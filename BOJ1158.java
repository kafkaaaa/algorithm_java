
/*
 * BOJ 1158번(S4) - 요세푸스 문제
 * Queue.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1158 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        int N = scan.nextInt();
        int K = scan.nextInt();

        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<N; i++) {
            q.add(i+1);         // 처음에는 큐에 1~N 삽입
        }

        while (!q.isEmpty()) {
            for (int i=0; i<K; i++) {
                // K번째 사람 제거 및 출력
                if (i == K-1) sb.append(q.poll()).append(", ");
                // K번째 사람이 아니면 빼서 다시 큐에 넣음
                else q.add(q.poll());
            }
        }
        sb.setLength(sb.length()-2);
        sb.append('>');
        System.out.println(sb);
    }
}
