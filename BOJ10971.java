/**
 * BOJ 10971번(S2)
 * Traveling Salesman Problem
 * 모든 도시들을 단 한 번만 방문하고 원래 시작점으로 돌아오는 최소 비용의 경로
 * #1. DFS
 * #2. Memoization + Bit Masking (주석)
 */
import java.io.*;
import java.util.*;

public class BOJ10971 {

    // #1. DFS 풀이
    static int N;
    static int[][] W;
    static boolean[] isVisited;
    static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        W = new int[N+1][N+1];
        isVisited = new boolean[N+1];

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isVisited[1] = true;
        DFS(1, 1, 1, 0);

        System.out.println(minCost);
    }


    private static void DFS(int start, int now, int cnt, int cost) {
        if (now == start && cost > 0) {
            minCost = Math.min(minCost, cost);
            return;
        }

        for (int n=1; n<=N; n++) {

            // now -> n 으로 경로가 존재하는 경우..
            if (W[now][n] > 0) {

                // 처음 시작점 도시는 이미 처음에 방문처리 되는데
                // 마지막에 다시 처음 시작점 도시로 돌아올 때 이미 방문처리 되어있기 때문에 별도로 처리
                // 모든 도시를 다 방문했고 출발점 도시로 가려는 경우
                if (cnt == N && n == start) {
                    cost += W[now][n];
                    DFS(start, n, cnt+1, cost);
                }

                // 시작점이 아닌 다른 도시들은 아직 방문하지 않은 경우만 방문.
                else if (!isVisited[n]) {
                    isVisited[n] = true;
                    cost += W[now][n];

                    DFS(start, n, cnt+1, cost);

                    isVisited[n] = false;
                    cost -= W[now][n];
                }
            }
        }
    }

}


//#2. Memoization + Bit Masking 풀이
//*Ref -> https://loosie.tistory.com/272
//	static int n, statusFullBit, INF = 987654321;
//	static int[][] w;
//	static int[][] dp;
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		n = Integer.parseInt(br.readLine());
//		statusFullBit = (1<<n) -1;	// ex) 도시의수(N)이 8개면 -> 1111_1111
//		w = new int[n][n];
//		dp = new int[n][statusFullBit];
//
//		// -1로 초기화.
//		for(int i=0; i<n; i++) {
//			Arrays.fill(dp[i], -1);
//		}
//
//		for(int i=0; i<n; i++) {
//			st = new StringTokenizer(br.readLine());
//			for(int j=0; j<n; j++) {
//				w[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//
//		System.out.println(traverse(0,1)); // 0번 도시 부터 탐색 시작 (check: 0001)
//	}
//
//	static int traverse(int x, int check) {		// check : visit check bit
//		// 모든 도시 방문 완료
//		if(check == statusFullBit) {
//			if(w[x][0] == 0) return INF; // 경로가 존재하지 않는 경우.
//			else return w[x][0]; 		 // 경로가 존재하면 w[x][0]
//		}
//
//		// 이미 방문한 도시
//		if(dp[x][check] != -1) return dp[x][check];
//
//		// 해당 도시에 방문 표시
//		dp[x][check] = INF;
//
//		// 방문하지 않은 도시 탐색
//		for(int i=0; i<n; i++) {
//			// next : i 도시 방문
//			int next = check | (1<<i);
//
//			// 경로가 없거나 i 도시를 이미 방문했을 경우 continue
//			if(w[x][i] == 0 || (check & (1<<i)) != 0) continue;
//
//			dp[x][check] = Math.min(dp[x][check], traverse(i, next) + w[x][i]);
//		}
//
//		return dp[x][check];
//	}
//}



