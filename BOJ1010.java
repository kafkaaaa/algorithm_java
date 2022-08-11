
/**
 * BOJ 1010번(S5) - 다리 놓기
 * 조합, DP
 * nCr = n-1Cr-1 + n-1Cr
 */

import java.util.Scanner;

public class BOJ1010 {

    static int[][] memo = new int[30][30];

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int tc=1; tc<=T; tc++) {
            int r = scan.nextInt();
            int n = scan.nextInt();
            System.out.println(combination(n, r));
        }
    }

    // nCr = n-1Cr-1 + n-1Cr
    static int combination(int n, int r) {

        // 이전에 계산된 값이면 바로 리턴
        if (memo[n][r] > 0) return memo[n][r];

        // nCn = 1,		nC0 = 1
        if (n == r || r == 0) return memo[n][r] = 1;

        // nCr = n-1Cr-1 + n-1Cr
        return memo[n][r] = combination(n-1, r-1) + combination(n-1, r);
    }

}
