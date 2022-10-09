/*
 * BOJ 2636번(G4)
 * BFS. 시뮬레이션.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2636 {
    static int R, C;
    static int[][] map;
    static boolean[][] isVisited;
    static int nCheese;     // 치즈가 있는 칸의 개수
    static int meltTime;    // 치즈가 모두 녹아서 없어지는 데 걸리는 시간
    static int ans;         // 모두 녹기 1시간 전에 남아있는 치즈 칸 개수
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for (int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) nCheese++;
            }
        }

        while (nCheese > 0) {
            meltTime++;
            ans = nCheese;  // 치즈가 모두 녹기 바로 이전에 남아있던 개수 구하기
            BFS();
        }

        System.out.println(meltTime + "\n" + ans);
    }


    // map의 (0,0)에서 BFS 시작
    // 다음 방문할 칸이 1이면 현재위치가 치즈의 가장자리임.
    // 치즈의 가장자리 위치를 기억해두고 이 부분을 0으로 교체.
    private static void BFS() {
        // ** ArrayDeque이 LinkedList보다 빠르다고 한다. (array의 cache-locality)
        Queue<Pos> q = new ArrayDeque<>();
        isVisited = new boolean[R][C];
        isVisited[0][0] = true;
        q.offer(new Pos(0, 0));

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            for (int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (isIn(nr, nc) && !isVisited[nr][nc]) {
                    if (map[nr][nc] == 0) {     // 0(빈칸)이면 계속 BFS 진행
                        isVisited[nr][nc] = true;
                        q.offer(new Pos(nr, nc));
                    } else {                    // 1이면 해당 칸이 치즈의 가장자리
                        isVisited[nr][nc] = true;
                        // 치즈 가장자리 1 -> 0으로 녹음
                        map[nr][nc] = 0;
                        nCheese--;
                    }
                }
            }
        }
    }

    private static boolean isIn(int r, int c) {
        return (r>=0 && c>=0 && r<R && c<C);
    }

    static class Pos {
        int r, c;
        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
