
/*
 * SWEA 1873번(D3) - 상호의 배틀필드
 * 2차원배열 상하좌우 이동 시뮬레이션
 */


import java.util.Scanner;

public class SWEA1873 {

    static int H, W;
    static char map[][];
    static int tankX, tankY;    // 전차의 현재 좌표
    static int tankDir;         // 전차의 현재 방향 (1상 2하 3좌 4우)

    // 상-하-좌-우
    // 상하좌우를 1,2,3,4로 쓰기 위해 dx dy의 처음에 의미없는 0을 넣어줌.
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};

    public static void main(String[] args) {

        // Input
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int tc=1; tc<=T; tc++) {

            // Init
            tankX = 0; tankY = 0; tankDir = 0;

            H = scan.nextInt();
            W = scan.nextInt();
            map = new char[H][W];    // 게임 맵

            for (int i=0; i<H; i++) {
                String s = scan.next();
                for (int j=0; j<W; j++) {
                    map[i][j] = s.charAt(j);

                    // 전차이면 좌표와 방향 저장. (전차는 오직 1개만 존재)
                    if (map[i][j] == '^' || map[i][j] == 'v' ||
                        map[i][j] == '<' || map[i][j] == '>') {
                        tankX = i;
                        tankY = j;
                        if (map[i][j] == '^')      tankDir = 1;
                        else if (map[i][j] == 'v') tankDir = 2;
                        else if (map[i][j] == '<') tankDir = 3;
                        else if (map[i][j] == '>') tankDir = 4;
                    }
                }
            }

            int N = scan.nextInt();     // 사용자가 넣을 입력의 개수
            String input = scan.next();
            for (int i=0; i<N; i++) {
                char cmd = input.charAt(i);

                // 상 하 좌 우 이동명령이면..
                if (cmd == 'U' || cmd == 'D' || cmd == 'L' || cmd == 'R') {
                    if (cmd == 'U') {
                        tankDir = 1;
                        map[tankX][tankY] = '^';
                    }
                    else if (cmd == 'D') {
                        tankDir = 2;
                        map[tankX][tankY] = 'v';
                    }
                    else if (cmd == 'L') {
                        tankDir = 3;
                        map[tankX][tankY] = '<';
                    }
                    else if (cmd == 'R') {      // else { ... }
                        tankDir = 4;
                        map[tankX][tankY] = '>';
                    }

                    int xx = tankX + dx[tankDir];
                    int yy = tankY + dy[tankDir];

                    // 맵을 벗어나지 않고 평지이면 이동
                    if (isInside(xx, yy) && map[xx][yy] == '.') {
                        map[xx][yy] = map[tankX][tankY];
                        map[tankX][tankY] = '.';    // 지나간 자리는 평지로
                        tankX = xx;
                        tankY = yy;
                    }
                }
                // 포탄 쏘기 명령이면..
                else if (cmd == 'S') {
                    int xx = tankX;
                    int yy = tankY;

                    while (true) {
                        xx += dx[tankDir];
                        yy += dy[tankDir];
                        // 맵을 벗어나거나 강철 벽과 만나면 중단
                        if (!isInside(xx, yy) || map[xx][yy] == '#') break;
                        // 벽돌 벽은 파괴시켜서 평지로 만듦
                        else if (map[xx][yy] == '*') {
                            map[xx][yy] = '.';
                            break;
                        }
                    }
                }

            }
            // Output
            System.out.print("#" + tc + " ");
            for (int i=0; i<H; i++) {
                for (int j=0; j<W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }

    }

    static boolean isInside(int x, int y) {
        return (x>=0 && x<H && y>=0 && y<W);
    }
}
