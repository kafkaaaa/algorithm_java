
/*
 * SWEA 1225번(D3) - 암호 생성기
 * Queue
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA1225 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        for (int tc=1; tc<=10; tc++) {
            scan.nextInt();
            Queue<Integer> q = new LinkedList<>();
            for (int i=0; i<8; i++)
                q.offer(scan.nextInt());

            int x = 1;
            while (true) {
                int tmp = q.poll() - x;
                if (tmp <= 0) {
                    tmp = 0;
                    q.offer(tmp);
                    break;
                }
                else q.offer(tmp);
                x = (x%5) + 1;  // 1cycle = 1 -> 2 -> 3 -> 4 -> 5
            }

            System.out.print("#" + tc + " ");
            while (!q.isEmpty()) {
                System.out.print(q.poll() + " ");
            }
            System.out.println();
        }
    }
}
