
/**
 * BOJ 10026번(G5)
 * DFS
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ10026 {
	
	static int N;
	static char map[][];
	static boolean isVisited[][];
	static int cnt1, cnt2;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		isVisited = new boolean[N][N];
		for (int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// 정상
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (!isVisited[i][j]) {
					DFS(i, j);
					cnt1++;
				}
			}
		}

		// 적록색약
		// R -> G로 바꾸고 시작, 방문배열도 초기화.
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (map[i][j] == 'R') map[i][j] = 'G';
			}
		}
		isVisited = new boolean[N][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (!isVisited[i][j]) {
					DFS(i, j);
					cnt2++;
				}
			}
		}
		
		System.out.println(cnt1 + " " + cnt2);
	}

	private static void DFS(int r, int c) {
		isVisited[r][c] = true;
		char curColor = map[r][c];
		for (int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr<0 || nc<0 || nr>=N || nc>=N || isVisited[nr][nc]) continue;
			if (map[nr][nc] == curColor) {	// 색이 같으면 계속 탐색
				DFS(nr, nc);
			}
		}
	}
}
