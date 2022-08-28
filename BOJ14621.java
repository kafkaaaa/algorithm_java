/**
 * BOJ 14621번(G3)
 * MST. Kruskal. Union-Find.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ14621 {

    static int V, E;	// 학교의 수, 도로의 수
    static char[] sex;	// 남학교=M, 여학교=W
    static int[] parent;
    static List<Edge> edgeList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        sex = new char[V+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=V; i++) {
            sex[i] = st.nextToken().charAt(0);
        }

        edgeList = new ArrayList<>();
        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            // u학교 -> v학교 (거리 d)
            edgeList.add(new Edge(u, v, d));
        }

        parent = new int[V+1];
        for (int i=1; i<=V; i++) {
            parent[i] = i;
        }

        // 가중치(간선 길이) 오름차순 정렬
        Collections.sort(edgeList, (o1, o2) -> o1.weight - o2.weight);

        int cnt = 0, ans = 0;

        // Kruskal
        int len = edgeList.size();
        for (int i=0; i<len; i++) {
            Edge e = edgeList.get(i);
            if (find(e.start) != find(e.end)) {
                if (sex[e.start] != sex[e.end]) {
                    cnt++;
                    ans += e.weight;
                    union(e.start, e.end);
                }
            }
        }

        // 경로 길이가 V-1이 아니면 MST를 만들 수 없다는 의미.
        if (cnt == V-1) System.out.println(ans);
        else System.out.println(-1);
    }


    // *Ref -> https://me2.kr/t5t3r
    // Kruskal : 음수 가중치가 없는 무방향 그래프에서 MST를 찾는 알고리즘.
    // MST -> 사이클이 발생하면 X.
    // 간선을 선택하기 전에 해당 간선이 연결하는 두 노드의 부모(대표자)를 확인하여
    // 같다면(같은 그래프에 속한다면) 해당 간선은 선택하지 X.
    // 사이클이 발생하는 경우 -> 같은 그래프에 속한 두 노드를 연결했을 때.
    // 선택한 두 노드가 같은 그래프에 속하는지 아닌지 판단 -> Union-Find.
    // Union Find : 어떤 두 임의의 원소가 같은 집합에 속하는지 판단.

    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) parent[y] = x;
    }

}

class Edge {
    int start;
    int end;
    int weight;

    Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}
