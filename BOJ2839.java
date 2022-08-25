/**
 * BOJ 2839번(S4)
 */
import java.util.Scanner;

public class BOJ2839 {

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        for (int i=0; i<=N/3; i++) {        // 3kg
            for (int j=0; j<=N/5; j++) {    // 5kg 먼저 계산
                if (i*3 + j*5 == N) {
                    System.out.println(i+j);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}