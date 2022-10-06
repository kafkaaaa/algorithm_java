/*
 * SWEA 3307번
 * LIS(가장 긴 증가하는 부분수열)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3307 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc=1; tc<=T; tc++) {
            int N = Integer.parseInt(br.readLine());    // 수열의 길이
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = Integer.MIN_VALUE;
            // 주어진 배열에서 인덱스를 하나씩 늘려가면서 검사
            int[] maxLen = new int[N];  // 주어진 수열의 각 인덱스까지의 LIS 길이 저장
            for (int i=0; i<N; i++) {
                maxLen[i] = 1;
                for (int j=0; j<i; j++) {
                    if (arr[i] > arr[j]) {                  // 더 큰 원소가 있고
                        if (maxLen[i] < maxLen[j] + 1) {    // LIS 길이가 더 커질 수 있을 때
                            maxLen[i] = maxLen[j] + 1;      // 값 업데이트
                        }
                    }
                    max = Math.max(max, maxLen[i]);
                }
            }
            System.out.println("#" + tc + " " + max);
        }
    }
}
