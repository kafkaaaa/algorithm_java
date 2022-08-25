/**
 * BOJ 1753번(G4)
 * Dijkstra. 인접 리스트.
 * 주어진 시작 정점에서 다른 모든 정점까지의 최단경로 구하기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1753 {

    static int V, E, start;
    static int[] dist;  // 주어진 시작 정점에서 각 정점까지의 최단거리 저장
    static ArrayList<Node>[] adjList;  // 인접 리스트

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());   // 1<=V<=20,000
        E = Integer.parseInt(st.nextToken());   // 1<=E<=300,000
        start = Integer.parseInt(br.readLine());   // 시작 정점 번호

        dist = new int[V + 1];        // 정점은 1번부터 시작
        adjList = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;    // 시작점~시작점 거리는 0

        // Edge 정보 저장 (u -> v로 가는 가중치가 w인 간선)
        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());   // 10이하의 자연수
            adjList[u].add(new Node(v, w));
        }

        Dijkstra();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            // 경로가 존재하지 않는 경우
            if (dist[i] == Integer.MAX_VALUE) sb.append("INF").append('\n');
            else sb.append(dist[i]).append('\n');
        }
        System.out.println(sb);
    }


    private static void Dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int v = current.vertex;
            int w = current.weight;

            // 최단경로가 아니면 넘어감..
            if (dist[v] < w) continue;

            // 현재 정점과 연결된 정점 탐색
            int len = adjList[v].size();
            for (int i = 0; i < len; i++) {
                int vv = adjList[v].get(i).vertex;
                int ww = adjList[v].get(i).weight + w;

                // 현재 경로가 더 짧은 경로이면 갱신..
                if (dist[vv] > ww) {
                    dist[vv] = ww;
                    pq.add(new Node(vv, ww));
                }
            }

        }
    }

    private static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

}
