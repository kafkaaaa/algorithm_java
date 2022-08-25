/**
 * BOJ 20361번(B3)
 * 구현. 시뮬레이션.
 */

import java.util.Scanner;

public class BOJ20361 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        // N개의 컵, X번째 컵에 공있음, 컵 swap은 K번 수행
        int N = scan.nextInt();
        int X = scan.nextInt();
        int K = scan.nextInt();
        int[] cup = new int[N+1];
        cup[X] = 1;
        for (int i=0; i<K; i++) {
            int n1 = scan.nextInt();
            int n2 = scan.nextInt();
            int tmp = cup[n1];
            cup[n1] = cup[n2];
            cup[n2] = tmp;
        }
        for (int i=1; i<N+1; i++) {
            if (cup[i] == 1) System.out.println(i);
        }
    }
}
