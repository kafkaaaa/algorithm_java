
/*
 * SWEA 2805번(D3)
 *
 */

import java.util.Scanner;

public class SWEA2805 {

    static int N;     // 농장의 크기 N x N

    public static void main(String[] args) {

        // 농장의 크기는 항상 홀수x홀수
        // 수확은 농장의 크기에 딱 맞는 마름모 형태로만 가능
        // 농장의 크기와 농작물의 가치가 주어질 때, 얻을 수 있는 수익은 얼마?

        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int tc=1; tc<=T; tc++) {
            N = scan.nextInt();
            int[][] farm = new int[N][N];
            for (int i = 0; i < N; i++) {
                String s = scan.next();
                for (int j = 0; j < N; j++) {
                    farm[i][j] = s.charAt(j) - '0';
                }
            }

            // Solve
            int earnings = 0, dx = 0;

            for (int i=0; i<N; i++) {
                int left = N/2 - dx;
                int right = N/2 + dx;
                for (int j=left; j<=right; j++) {
                    earnings += farm[i][j];
                }
                if (i >= N/2) dx--;
                else dx++;
            }
            System.out.println("#" + tc + " " + earnings);
        }
    }
}
