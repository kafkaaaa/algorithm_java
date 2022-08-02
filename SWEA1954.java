
/*
 * SWEA 1954번(D2)
 *
 */

import java.util.Scanner;

public class SWEA1954 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int tc=1; tc<=T; tc++) {
            int N = scan.nextInt();     // NxN 정사각형
            int map[][] = new int[N][N];

            int num = 1;
            int startX = 0, startY = 0, endX = N - 1, endY = N - 1;
            while (true) {
                if (num > N * N) break;   // 마지막 (종료조건)

                for (int y = startY; y <= endY; y++) {  // 오른쪽으로 이동
                    map[startX][y] = num++;
                }
                startX++;   // x좌표+1

                for (int x = startX; x <= endX; x++) {  // 아래로 이동
                    map[x][endY] = num++;
                }
                endY--;     // y좌표-1

                for (int y = endY; y >= startY; y--) {  // 다시 왼쪽으로 이동
                    map[endX][y] = num++;
                }
                endX--;     // x좌표-1

                for (int x = endX; x >= startX; x--) {  // 오른쪽으로 이동
                    map[x][startY] = num++;
                }
                startY++;   // y좌표+1
            }

            System.out.println("#" + tc);
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
