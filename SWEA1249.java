import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * SWEA 1249번(D4)
 * BFS.
 */
public class SWEA1249 {

    static int N;
    static int[][] map;
    static int[][] memo; // 해당 좌표까지의 최단시간 기록
    static boolean[][] isVisited;
    static int ans;

    static int[] dr = {-1, 1, 0, 0};    // 상하좌우 delta
    static int[] dc = {0, 0, -1, 1};

    // (0,0) -> (N-1, N-1)
    // 출발지에서 도착지까지 가는 경로 중에 복구 "시간이 가장 짧은 경로" 에 대한 총 복구 시간을 구하시오.
    // 가중치가 가장 최소인 경로 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc=1; tc<=T; tc++) {
            ans = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            memo = new int[N][N];
            isVisited = new boolean[N][N];
            for (int i=0; i<N; i++) {
                String s = br.readLine();
                for (int j=0; j<N; j++) {
                    map[i][j] = s.charAt(j) - '0';
                }
            }
            BFS(0, 0);
            System.out.println("#" + tc + " " + ans);
        }
    }


    private static void BFS(int r, int c) {
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(r, c));
        while (!q.isEmpty()) {
            Pos pos = q.poll();
            if (pos.r == N-1 && pos.c == N-1) {
                ans = Math.min(ans, memo[pos.r][pos.c]);
                continue;
            }

            if (ans <= memo[pos.r][pos.c]) continue;

            for (int i=0; i<4; i++) {
                int nr = pos.r + dr[i];
                int nc = pos.c + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                if (!isVisited[nr][nc] || memo[pos.r][pos.c] + map[nr][nc] < memo[nr][nc]) {
                    isVisited[nr][nc] = true;
                    memo[nr][nc] = memo[pos.r][pos.c] + map[nr][nc];
                    q.offer(new Pos(nr, nc));
                }
            }
        }
    }


    static class Pos {
        int r, c;
        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
