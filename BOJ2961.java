/**
 * BOJ 2961번(S2)
 * Bit Masking
 */
import java.util.Scanner;

public class BOJ2961 {

    static int N;               // 재료의 개수 1<=N<=10
    static int[] sour, bitter;  // 신맛, 쓴맛
    static int MIN = Integer.MAX_VALUE;
    // 음식의 신맛은 신맛의 곱이고, 쓴맛은 합이다.
    // 재료의 신맛과 쓴맛이 주어졌을 때, 신맛과 쓴맛의 차이가 가장 작은 요리를 만드는 프로그램을 작성하시오.

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        sour = new int[N];
        bitter = new int[N];
        for (int i=0; i<N; i++) {
            sour[i] = scan.nextInt();
            bitter[i] = scan.nextInt();
        }

        // 비트마스킹 풀이
        for (int i=1; i < 1<<N; i++) {
            int sour_product = 1;
            int sum_bitter = 0;

            for (int j=0; j<N; j++) {
                if ((i & 1<<j) > 0) {
                    sour_product *= sour[j];
                    sum_bitter += bitter[j];
                }
            }
            int diff = Math.abs(sour_product - sum_bitter);
            MIN = Math.min(MIN, diff);
        }
        System.out.println(MIN);
    }
}
