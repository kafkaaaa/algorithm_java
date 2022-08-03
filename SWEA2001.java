
/*
 * SWEA 2001번(D2) - 파리 퇴치
 * 2차원배열에서 특정한 부분의 최대합 구하기
 */

import java.util.Scanner;

public class SWEA2001 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int tc=1; tc<=T; tc++) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int[][] map = new int[N][N];

            for (int i=0; i<N; i++)
                for (int j=0; j<N; j++)
                    map[i][j] = scan.nextInt();

            int maxSum = 0;
            for (int i=0; i<N-M+1; i++) {
                for (int j=0; j<N-M+1; j++) {

                    int tmpSum = 0;
                    for (int a=0; a<M; a++) {
                        for (int b=0; b<M; b++) {
                            tmpSum += map[i+a][j+b];
                        }
                    }
                    if (tmpSum > maxSum) maxSum = tmpSum;
                }
            }
            System.out.println("#" + tc + " " + maxSum);
        }
    }

}
