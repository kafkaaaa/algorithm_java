/**
 * BOJ 1074번(S1)
 * 분할정복.
 */

import java.util.Scanner;

public class BOJ1074 {

    // Z모양 delta
    private final static int[] dr = {0, 0, 1, 1};
    private final static int[] dc = {0, 1, 0, 1};
    private static int N, targetR, targetC, cnt;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        targetR = scan.nextInt();
        targetC = scan.nextInt();
        int size = (int) Math.pow(2, N);    // 2^N
        search_Z(size, targetR, targetC);
    }

    private static void search_Z(int size, int row, int col) {
        if (size == 1) {
            System.out.println(cnt);
            return;
        }

        int ss = size/2;       // 4등분한 사각형의 한 변의 길이
        if (row < ss && col < ss) {             // 1사분면 (좌상)
            search_Z(ss, row, col);
        }
        else if (row < ss && col < size) {      // 2사분면 (우상)
            cnt += ss * ss;     // 1사분면의 개수만큼 더해줌
            search_Z(ss, row, col-ss);
        }
        else if (row < size && col < ss) {      // 3사분면 (좌하)
            cnt += ss * ss * 2; // 1,2사분면의 개수만큼 더해줌
            search_Z(ss, row-ss, col);
        }
        else if (row < size && col < size) {    // 4사분면 (우하)
            cnt += ss * ss * 3; // 1,2,3사분면의 개수만큼 더해줌
            search_Z(ss, row - ss, col - ss);
        }
    }

}
