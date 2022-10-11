/*
 * BOJ 9205번(S1)
 * 플로이드-와샬
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ9205 {

    static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N;   // 편의점의 수
    static List<Pos> list;
    static boolean[][] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            list = new ArrayList<Pos>();
            d = new boolean[N+2][N+2];
            for (int i=0; i<d[0].length; i++) {
                Arrays.fill(d[i], false);
            }

            st = new StringTokenizer(br.readLine());
            list.add(new Pos(stoi(st.nextToken()), stoi(st.nextToken())));

            for (int i = 0; i < N; i++) {   // 편의점(N개)
                st = new StringTokenizer(br.readLine());
                list.add(new Pos(stoi(st.nextToken()), stoi(st.nextToken())));
            }
            st = new StringTokenizer(br.readLine());
            list.add(new Pos(stoi(st.nextToken()), stoi(st.nextToken())));

            // 각 정점들 사이의 dist가 1000이하면 d[][] = true
                // 다음 N+2개 줄에는 집, 편의점, 목적지 좌표가 주어진다.
            for (int i = 0; i < N + 2; i++) {
                for (int j = i + 1; j < N + 2; j++) {
                    if (getDist(list.get(i), list.get(j)) <= 1000) {
                        d[i][j] = true;
                        d[j][i] = true;
                    }
                }
            }

            floyd_warshall();

            if (d[0][N+1]) System.out.println("happy");
            else System.out.println("sad");
        }
    }

    // floyd-warshall : i->j && j->k  ==>  i->k
        // if (d[i][j] && d[j][k])  then  d[i][k] = true
    /**
     * 주의할점 !!
     * 3중 for문에서  출발지 --> 경유지 --> 목적지 로 돌리면 X
     * 경유지 --> 출발지 --> 목적지로 돌려야 한다!
     */
    private static void floyd_warshall() {
        for (int k = 0; k < N + 2; k++) {       // 경유지 k
            for (int i = 0; i < N + 2; i++)     // 출발지 i
                for (int j = 0; j < N + 2; j++) // 도착지 j
                    if (d[i][k] && d[k][j]) d[i][j] = true;
        }
    }

    // 맨해튼 거리 리턴
    private static int getDist (Pos p1, Pos p2) {
        return Math.abs(p1.r - p2.r) + Math.abs(p1.c - p2.c);
    }

    private static int stoi (String s) {
        return Integer.parseInt(s);
    }

}
