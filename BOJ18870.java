
/*
 * BOJ 18870번(S2) - 좌표 압축
 * 정렬. Ranking List
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class BOJ18870 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int origin[] = new int[N];  // 원본 배열
        int sorted[] = new int[N];  // 정렬된 배열
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i=0; i<N; i++) {
            origin[i] = sorted[i] = scan.nextInt();
        }
        Arrays.sort(sorted);

        // 정렬된 배열을 순회하면서 HashMap에 넣어줌
        int rank = 0;
        for (int e : sorted) {
            // 이미 순위가 있으면 중복되면 X
            // 중복이 아닌 경우만 rank를 넣어줌
            if (!hm.containsKey(e)) {
                hm.put(e, rank++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int key : origin) {
            int origin_rank = hm.get(key);
            sb.append(origin_rank).append(" ");
        }

        System.out.println(sb);
    }
}
