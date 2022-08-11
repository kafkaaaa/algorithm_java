
/**
 * BOJ 16926번(S1) - 배열 돌리기1
 */

import java.util.Scanner;

public class BOJ16926 {

    static int N, M, R;
    static int[][] arr;

    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();		// NxM 배열
        M = scan.nextInt();
        R = scan.nextInt();		// 수행해야 하는 회전의 수
        arr = new int[N][M];
        for (int i=0; i<N; i++)
            for (int j=0; j<M; j++)
                arr[i][j] = scan.nextInt();

        rotateArr();
        print(arr);
    }


    static void rotateArr() {

        int cnt = Math.min(N, M) / 2;		// 회전해야 할 사각형의 수

        for (int i=0; i<R; i++) {			// 총 i번 회전

            for (int j=0; j<cnt; j++) {
                int dir = 0;
                int x = j;
                int y = j;
                int tmp = arr[j][j];

                while(dir < 4) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];

                    if (nx >= j && nx < N-j && ny >= j && ny < M-j) {
                        arr[x][y] = arr[nx][ny];
                        x = nx;
                        y = ny;
                    }
                    else dir++;
                }
                arr[j+1][j] = tmp;
            }
        }
    }


    static void print(int[][] arr) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}

