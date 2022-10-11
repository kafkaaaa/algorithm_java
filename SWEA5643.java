/*
 * SWEA 5643번(D4)
 * BFS
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA5643 {
	
	static int N, M;					// 학생수, 키 비교 횟수
	static int[][] adj;					// 인접행렬
	static int shortCnt, tallCnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			adj = new int[N][N];

			for (int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				// 문제에서는 학생의 번호가 1부터 시작
				adj[a-1][b-1] = 1;	// a보다 b가 키가 크다.
			}
			
			// BFS
			// 연결된 노드를 따라가면서 나보다 크거나 작은 학생의 수를 카운팅.
			// 나보다 작은 사람 수 + 나보다 큰 사람 수 = N-1 이면
			// 자신의 키가 정확히 몇 번째인지 알 수 있다.
			int ans = 0;
			for (int i=0; i<N; i++) {
				shortCnt = tallCnt = 0;
				shortBFS(i);
				tallBFS(i);
				if (shortCnt + tallCnt == N-1) ans++;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	// start 학생부터 자신보다 키가 작은 학생따라 탐색
	private static void shortBFS(int startIdx) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] isVisited = new boolean[N];
		isVisited[startIdx] = true;
		q.offer(startIdx);

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i=0; i<N; i++) {
				if (adj[i][cur] == 1 && !isVisited[i]) {
					isVisited[i] = true;
					q.offer(i);
					shortCnt++;
				}
			}
		}
	}
	
	// start 학생부터 자신보다 키가 큰 학생따라 탐색
	private static void tallBFS(int startIdx) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] isVisited = new boolean[N];
		isVisited[startIdx] = true;
		q.offer(startIdx);

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i=0; i<N; i++) {	// 자신의 인접행렬 들여다보기
				// i번째 학생이 cur학생보다 키가 크고, 아직 탐색하지 않았다면
				if (adj[cur][i] == 1 && !isVisited[i]) {
					isVisited[i] = true;
					q.offer(i);
					tallCnt++;
				}
			}
		}
	}

}
