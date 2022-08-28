
/**
 * SWEA 3124번(D4)
 * 최소 신장 트리. Union-Find
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA3124 {

	static int T, V, E;
	static int parents[];
	static Edge edgeList[];
	static long result;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			parents = new int[V + 1];
			edgeList = new Edge[E];

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				edgeList[i] = new Edge(A, B, C);
			}

			make();
			Arrays.sort(edgeList);

			result = 0;
			int count = 0;
			for (Edge e : edgeList) {
				if (union(e.from, e.to)) {
					result += e.weight;
					count++;
					if (count == V - 1)
						break;
				}
			}
			System.out.println("#" + tc + " " + result);
		}
	}

	static void make() {
		for (int i = 0; i <= V; i++) {
			parents[i] = i;
		}
	}

	static int find(int a) {
		if (parents[a] == a)
			return a;
		else
			return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;
		else {
			parents[bRoot] = aRoot;
			return true;
		}
	}
}

class Edge implements Comparable<Edge> {

	int from, to, weight;

	public Edge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}
}
