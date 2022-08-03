
/*
 * BOJ 11659번(S3) - 구간 합 구하기4
 * 누적 합
 */

import java.util.Scanner;

public class BOJ11659 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] num = new int[N+1];   // 누적합 저장
        int M = scan.nextInt();
        for (int i=1; i<=N; i++) {
            num[i] = num[i-1] + scan.nextInt();
        }
        for (int i=0; i<M; i++) {
            // start ~ end 까지 구간합 구하기
            // = (num[end] 까지의 누적합 - num[start-1] 까지의 누적합)
            int start = scan.nextInt();
            int end = scan.nextInt();
            System.out.println(num[end] - num[start-1]);
        }
    }

}
