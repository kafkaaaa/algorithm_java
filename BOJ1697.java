
/*
 * BOJ 1697번(S1) - 숨바꼭질
 * BFS. Queue.
 * 참고 -> https://smartpro.tistory.com/18
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {

    // 현재위치 N 에서 K위치로 최단시간으로 가는 경로 찾기
    // 0 <= N, K <= 100,000
    // X -> (1초 후) X-1 or X+1
    // X -> (0초 후) X*2

    static boolean isVisited[] = new boolean[200_001];
    static int time[] = new int[200_001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) {               // 예외 1 : N==K인 경우 0초
            System.out.println(0);
        }
        else if (N > K) {           // 예외 2 : N>K인 경우 N-K초
            System.out.println(N-K);
        }
        else {
            BFS(N);
            System.out.println(time[K]);
        }
    }


    static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        isVisited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            // +1 이동
            if (cur + 1 <= 200_000 && !isVisited[cur + 1]) {
                q.add(cur + 1);
                isVisited[cur + 1] = true;
                time[cur + 1] = time[cur] + 1;
            }

            // -1 이동
            if (cur - 1 >= 0 && !isVisited[cur - 1]) {
                q.add(cur - 1);
                isVisited[cur - 1] = true;
                time[cur - 1] = time[cur] + 1;
            }

            // *2 이동
            if (cur * 2 <= 200_000 && !isVisited[cur * 2]) {
                q.add(cur * 2);
                isVisited[cur * 2] = true;
                time[cur * 2] = time[cur] + 1;
            }
        }
    }

}
