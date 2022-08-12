/**
 * SWEA 1227번(D4)
 * 미로 탐색. DFS.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA1227 {
	
	static int[] dr = {-1, 1, 0, 0};	// 상,하,좌,우
	static int[] dc = {0, 0, -1, 1};
	static char[][] map = new char[100][100];
	static int answer;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; ++tc) {
			br.readLine();
			answer = 0;		
			for (int i = 0; i < 100; ++i) {
				map[i] = br.readLine().toCharArray();
			}
			
			DFS(1, 1);	// 미로의 시작점은 (1,1)
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	
	public static void DFS(int r, int c) {
		map[r][c] = '1';
		
		for (int i = 0; i < 4; ++i) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr < 0 || nc < 0 || nr >= 100 || nc >= 100) {
				continue;
			}
			
			if (map[nr][nc] == '3') {
				answer = 1;
				return;
			}
		
			if (map[nr][nc] == '0') {
				DFS(nr, nc);
			}
		}
	}
}