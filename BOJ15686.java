/**
 * BOJ 15686번(G5)
 * DFS. 조합.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
public class BOJ15686 {
	
    static int N;					// N(2 ≤ N ≤ 50) -> 도시의 크기 NxN
    static int M;					// M(1 ≤ M ≤ 13) -> 남길 치킨집의 개수
    static int[][] city;
    static List<Pos> house;			// 집의 좌표 저장
    static List<Pos> chicken;		// 치킨집의 좌표 저장
    static boolean[] isSelected;	// 남길 치킨집 선택
    static int minDist = Integer.MAX_VALUE;
 
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N];
        house = new ArrayList<>();
        chicken = new ArrayList<>();
 
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 1)		house.add(new Pos(i, j));
                else if (city[i][j] == 2)	chicken.add(new Pos(i, j));
            }
        }
        isSelected = new boolean[chicken.size()];
 
        DFS(0, 0);
        System.out.println(minDist);
    }
 
    
    public static void DFS(int start, int cnt) {
    	
        if (cnt == M) {				// 치킨집 선택 완료
            int chickenDist = 0;	// 치킨거리 = 각 집에서 가장 가까운 치킨집까지의 거리들의 합 중 최소값
 
            for (int i=0; i<house.size(); i++) {
                int dist = Integer.MAX_VALUE;
 
                // dist = 어떤 집과 가장 가까운 거리에 있는 치킨집과의 거리(x,y좌표 차이)
                for (int j=0; j<chicken.size(); j++) {
                    if (isSelected[j]) {
                    	int xDiff = Math.abs(house.get(i).x - chicken.get(j).x);
                    	int yDiff = Math.abs(house.get(i).y - chicken.get(j).y);
                        dist = Math.min(dist, xDiff + yDiff);
                    }
                }
                chickenDist += dist;
            }
            // 치킨 거리의 최소값을 구함
            minDist = Math.min(minDist, chickenDist);
            return;
        }
 
        for (int i=start; i<chicken.size(); i++) {
            isSelected[i] = true;
            DFS(i+1, cnt+1);
            isSelected[i] = false;
        }
    }
 
}


class Pos {
	int x, y;

	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}