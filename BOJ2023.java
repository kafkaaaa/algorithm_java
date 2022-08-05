
/*
 * BOJ 2023번(G5) - 신기한 소수
 * 소수 판정, DFS
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2023 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 1<=N<=8 : N자리 숫자
        DFS_prime(0, N);
    }

    // N자리의 수가 신기한 소수인지 판별할 때..
    // 첫째자리 부터 하나씩 늘려가면서 소수가 되는 경우만 계속 진행
    private static void DFS_prime(int num, int radix) {
        if (radix == 0) System.out.println(num);

        for (int i=1; i<10; i++) {
            int tmp = num*10 + i;   // 기존 수의 맨 뒤에 i를 붙여서 만든 새로운 수
            if (radix>0 && isPrime(tmp)) {
                DFS_prime(tmp, radix-1);
            }
        }
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        for (int i=2; i*i<=n; i++) {
            if (n%i == 0) return false;
        }
        return true;
    }
}
