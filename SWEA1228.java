
/*
 * SWEA 1228번(D3) - 암호문1
 * List 활용.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA1228 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc=1; tc<=10; tc++) {
            sb.append("#" + tc + " ");
            List<String> list = new LinkedList<>();
            int N = Integer.parseInt(br.readLine());    // 10 <= N <= 20 원본 암호문의 길이
            String origin[] = br.readLine().split(" ");
            for (int i=0; i<N; i++) {
                list.add((origin[i]));
            }

            int k = Integer.parseInt(br.readLine());    // 5 <= k <= 10 명령어의 개수
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input, " ");
            for (int j=0; j<k; j++) {
                st.nextToken();     // I는 그냥 버림
                int startPos = Integer.parseInt(st.nextToken());    // 시작 위치
                int nOfCrypt = Integer.parseInt(st.nextToken());      // 새로운 암호문 개수
                for (int x=0; x<nOfCrypt; x++) {
                    int insertPos = startPos + x;        // 삽입 위치
                    String newCrypt = st.nextToken();    // 새로운 암호문
                    list.add(insertPos, newCrypt);
                }
            }

            // Output
            for (int i=0; i<10; i++) {
                sb.append(list.get(i) + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}