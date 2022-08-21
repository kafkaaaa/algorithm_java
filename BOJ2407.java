/**
 * BOJ 2407번(S4)
 * 조합. DP. BigInteger.
 */

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ2407 {

    static BigInteger dp[][];

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        // nCm 구하기  (5<=n<=100,  5<=m<=100,  m<=n)
        // nCr = n-1Cr-1 + n-1Cr
        // long 범위를 넘는 매우 큰 수 -> BigInteger (클래스)
        dp = new BigInteger[n+1][n+1];
        comb_dp(n, m);
        System.out.println(dp[n][m]);
    }

    // DP - Memoization
    private static void comb_dp(int n, int m) {
        for (int i=1; i<=n; i++) {
            for (int j=0; j<=i; j++) {
                if (i == j || j == 0)   // nCn = 1,     nC0 = 1
                    dp[i][j] = new BigInteger("1");
                else    // nCr = n-1Cr-1 + n-1Cr
                    dp[i][j] = dp[i-1][j-1].add(dp[i-1][j]);
            }
        }
    }


    // 아래처럼 재귀로 하면 시간초과.
    private static int comb_recur(int n, int m) {
        // nCn = 1,     nC0 = 1
        if (n==m || m==0) return 1;
        // nCr = n-1Cr-1 + n-1Cr
        else return comb_recur(n-1, m-1) + comb_recur(n-1, m);
    }
}
