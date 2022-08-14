/**
 * SWEA 1861번(D4)
 */
// NxN 형태의 방이 있다  (1<=N<=1000)
// (i,j)방에는 1이상 N^2 이하의 수A[i][j]가 적혀 있다. (1<=A[][]<=N^2)
// 현재 위치보다 1이 큰 수가 있는 방으로 이동할 수 있다. (상하좌우)
// 처음 어느 위치에서 시작해야 가장 많은 이동을 할 수 있는가?

import java.util.Scanner;

public class SWEA1861 {

    static int N;
    static int map[][];
    static int moveCnt;

    // 2차원 배열 상하좌우 이동 delta
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int tc=1; tc<=T; tc++) {
            N = scan.nextInt();
            map = new int[N][N];
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    map[i][j] = scan.nextInt();
                }
            }

            int max = 0;	// 최대로 이동할 수 있는 횟수
            int res = 0;	// 최대로 이동할 수 있는 방에 적힌 숫자들 중 가장 작은 수
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    moveCnt = 1;
                    move(i, j);
                    if (max < moveCnt) {
                        max = moveCnt;
                        res = map[i][j];
                    }
                    else if (max == moveCnt) {
                        res = Math.min(res, map[i][j]);
                    }
                }
            }

            System.out.println("#" + tc + " " + res + " " + max);
        }
    }


    static void move(int r, int c) {
        for (int i=0; i<4; i++) {
            int rr = r + dr[i];
            int cc = c + dc[i];
            if (isInside(rr, cc)) {
                if (map[rr][cc] - map[r][c] == 1) {
                    moveCnt++;
                    move(rr, cc);
                }
            }
        }
    }


    static boolean isInside(int r, int c) {
        if (r >= 0 && r <= N-1 && c >=0 && c <= N-1)
            return true;
        return false;
    }

}

