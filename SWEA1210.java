
/*
 * SWEA 1210번(D4) - Ladder1
 * 사다리타기 게임에서 도착지점이 주어질 때 출발지점 찾아내기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1210 {

    static int[][] map;
    static int x, y;  // 도착지점 좌표

    public static void main(String[] args) throws IOException {

        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();
            map = new int[100][100];
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }

            // 도착지점 얻기
            for (int i = 0; i < 100; i++) {
                if (map[99][i] == 2) {
                    x = 99;
                    y = i;
                    break;
                }
            }

            // 도착점 -> 출발점(y좌표가 0이 될 때까지) 탐색
            while (x != 0) {

                map[x][y] = 0;  // 방문한 곳은 0으로 처리

                // 왼쪽으로 갈 수 있을 때
                if (y - 1 >= 0 && map[x][y - 1] == 1) y--;

                // 오른쪽으로 갈 수 있을 때
                else if (y + 1 <= 99 && map[x][y + 1] == 1) y++;

                // 왼쪽, 오른쪽으로 갈 수 없다면 그냥 위로 한칸 이동
                else x--;
            }
            System.out.println("#" + tc + " " + y);
        }
    }
}
