
/*
 * BOJ 11660번(S1) - 구간 합 구하기5
 * 2차원배열 누적 합, 구간 합, DP
 */

import java.util.Scanner;

public class BOJ11660 {

    static int map[][];
    static int dp[][];  // (1,1) ~ (x,y) 까지 누적 합 저장

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        map = new int[N+1][N+1];
        dp = new int[N+1][N+1];
        int M = scan.nextInt();
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                map[i][j] = scan.nextInt();
            }
        }
        // 누적합 계산 및 저장
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                // (i,j)까지 누적합 = 한칸 위 + 한줄 옆 - 중복된 부분 + (i,j)값
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + map[i][j];
            }
        }

        for (int i=0; i<M; i++) {
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            int x2 = scan.nextInt();
            int y2 = scan.nextInt();
            // (x1,y1) ~ (x2,y2) 누적 합 구하기
            // = dp(x2, y2) - dp(x2, y1-1) - dp(x1-1, y2) + dp(x1-1, y1-1)
            System.out.println(dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1]);
        }

    }
}
