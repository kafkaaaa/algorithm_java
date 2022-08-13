/**
 * SWEA 4012번
 * 조합.
 */
import java.util.Scanner;

public class SWEA4012 {
	
	static int N;				// 식재료의 수  4 ≤ N ≤ 16
	static int[][] Synergy;		// 각 재료와의 시너지
	static boolean[] isSelected;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int tc=1; tc<=T; tc++) {
			N = scan.nextInt();
			Synergy = new int[N][N];
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++)
					Synergy[i][j] = scan.nextInt();
			}
			isSelected = new boolean[N];
			comb(0, 0);
			System.out.println("#" + tc + " " + ans);
		}
	}
	
	// 식재료N개 중에서 N/2개를 뽑는 조합.
	static void comb(int cnt, int start) {
		if (cnt == N/2) {
			// 음식 A와 B의 시너지 계산하기
			int synergyA = 0, synergyB = 0;
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (i==j) continue;
					if (isSelected[i] && isSelected[j])
						synergyA += Synergy[i][j];
					else if (!isSelected[i] && !isSelected[j])
						synergyB += Synergy[i][j];
				}
			}
			// 음식 A와 B의 맛의 차이
			int diff = Math.abs(synergyA - synergyB);
			ans = Math.min(ans, diff);
			return;
		}
		
		for (int i=start; i<N; i++) {
			isSelected[i] = true;
			comb(cnt+1, start+1);
			isSelected[i] = false;
		}
	}

}
